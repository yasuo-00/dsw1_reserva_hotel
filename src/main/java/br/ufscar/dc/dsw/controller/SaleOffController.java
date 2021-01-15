package br.ufscar.dc.dsw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.classes.BookingSite;
import br.ufscar.dc.dsw.classes.Hotel;
import br.ufscar.dc.dsw.classes.SaleOff;
import br.ufscar.dc.dsw.classes.User;
import br.ufscar.dc.dsw.security.UserAccount;
import br.ufscar.dc.dsw.service.spec.IBookingSiteService;
import br.ufscar.dc.dsw.service.spec.IHotelService;
import br.ufscar.dc.dsw.service.spec.ISaleOffService;

@Controller
@RequestMapping("/saleOffs")
public class SaleOffController {

	@Autowired
	private ISaleOffService saleOffService;

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private IBookingSiteService bookingSiteService;

	private User getUser() {
		UserAccount usuarioDetails = (UserAccount) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return usuarioDetails.getUser();
	}

	@GetMapping("/list")
	public String listAll(ModelMap model) {
		if (this.getUser().getRole().compareTo("ROLE_BOOKINGSITE") == 0) {
			model.addAttribute("saleOffs", saleOffService.findAllByBookingSite(this.getUser().getId()));
		}
		else if (this.getUser().getRole().compareTo("ROLE_HOTEL") == 0) {
			model.addAttribute("saleOffs", saleOffService.findAllByHotel(this.getUser().getId()));
		}else {
			model.addAttribute("saleOffs", saleOffService.findAll());
		}
		
		return "saleOff/list";
	}

	@PostMapping("/save")
	public String save(@Valid SaleOff saleOff, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "saleOff/register";
		}


		saleOffService.save(saleOff);
		attr.addFlashAttribute("success", "SaleOff inserted successfully");
		return "redirect:/saleOffs/list";
	}

	@GetMapping("/register")
	public String register(Model model, @AuthenticationPrincipal UserAccount currentUser, SaleOff saleOff) {
		model.addAttribute("user", currentUser);
		System.out.println(currentUser.getId());
		return "/saleOff/register";
	}

	// talvez tenha que mudar para post
	@GetMapping("/edit/{id}")
	public String preEdit(@PathVariable("id") Long id, ModelMap model) {
		SaleOff s = saleOffService.findById(id);
		model.addAttribute("saleOff", saleOffService.findById(id));
		return "saleOff/register";
	}

	@PostMapping("/edit")
	public String edit(@Valid SaleOff saleOff, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "saleOff/register";
		}
		
		if(this.getUser().getRole().compareTo("ROLE_HOTEL")==0){
			saleOff.setHotel(hotelService.findById(this.getUser().getId()));
		}

		saleOffService.save(saleOff);
		attr.addFlashAttribute("success", "SaleOff edited successfully");
		return "redirect:/saleOffs/list";
	}

	@GetMapping("/remove/{id}")
	public String remove(@PathVariable("id") Long id, RedirectAttributes attr) {
		saleOffService.remove(id);
		attr.addFlashAttribute("success", "SaleOff removed successfully");
		return "redirect:/saleOffs/list";
	}

	@ModelAttribute("hotels")
	public List<Hotel> listHotel() {
		return hotelService.findAll();
	}

	@ModelAttribute("bookingSites")
	public List<BookingSite> listBookingSite() {
		return bookingSiteService.findAll();
	}

}
