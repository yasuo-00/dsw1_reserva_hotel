package br.ufscar.dc.dsw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.classes.BookingSite;
import br.ufscar.dc.dsw.classes.Hotel;
import br.ufscar.dc.dsw.classes.SaleOff;
import br.ufscar.dc.dsw.security.UserAccount;
import br.ufscar.dc.dsw.service.spec.IBookingSiteService;
import br.ufscar.dc.dsw.service.spec.IHotelService;
import br.ufscar.dc.dsw.service.spec.ISaleOffService;

@Controller
@RequestMapping("/saleOff")
public class SaleOffController {
	
	@Autowired
	private ISaleOffService saleOffService;
	
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IBookingSiteService bookingSiteService;
	

	@GetMapping("/list")
	public String listAll(@RequestParam(value="hotelId", required=false) Long hotelId , @RequestParam(value="bookingSiteId", required=false) Long bookingSiteId ,ModelMap model) {
		if(hotelId!=null) {
			model.addAttribute("saleOffs", saleOffService.findAllByHotel(hotelId));
		}else if (bookingSiteId!=null){
			model.addAttribute("saleOffs", saleOffService.findAllByBookingSite(bookingSiteId));
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
		return "redirect:/saleOff/list";
	}
	
	@GetMapping("/register")
	public String register(Model model, @AuthenticationPrincipal UserAccount currentUser, SaleOff saleOff) {
		model.addAttribute("hotelId",currentUser.getId());
		System.out.println(currentUser.getId());
		return "/saleOff/register";
	}

	// talvez tenha que mudar para post
	@GetMapping("/edit/{id}")
	public String preEdit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("saleOff", saleOffService.findById(id));
		return "saleOff/register";
	}

	@PostMapping("/edit")
	public String edit(@Valid SaleOff saleOff, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "saleOff/register";
		}

		saleOffService.save(saleOff);
		attr.addFlashAttribute("success", "SaleOff edited successfully");
		return "redirect:/saleOff/list";
	}

	@GetMapping("/remove/{id}")
	public String remove(@PathVariable("id") Long id, RedirectAttributes attr) {
		saleOffService.remove(id);
		attr.addFlashAttribute("success", "SaleOff removed successfully");
		return "redirect:/saleOff/list";
	}
	
	@ModelAttribute("hotels")
	public List<Hotel> listHotel(){
		return hotelService.findAll();
	}
	
	@ModelAttribute("bookingSites")
	public List<BookingSite> listBookingSite(){
		return bookingSiteService.findAll();
	}

}
