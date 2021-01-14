package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.classes.BookingSite;
import br.ufscar.dc.dsw.classes.Hotel;
import br.ufscar.dc.dsw.service.spec.IBookingSiteService;


@Controller
@RequestMapping("/bookingSites")
public class BookingSiteController {

	@Autowired
	private IBookingSiteService bookingSiteService;
	
	/*
	 * @Autowired private IUserService userService;
	 */
	
	@Autowired
	private BCryptPasswordEncoder encoder;


	@GetMapping("/list")
	public String listAll(ModelMap model) {
		model.addAttribute("bookingSites", bookingSiteService.findAll());
		return "bookingSite/list";
	}

	@PostMapping("/save")
	public String save(@Valid BookingSite bookingSite, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "bookingSite/register";
		}
		
		bookingSite.setPassword(encoder.encode(bookingSite.getPassword()));
		bookingSiteService.save(bookingSite);
		attr.addFlashAttribute("success", "BookingSite inserted successfully");
		return "redirect:/bookingSites/list";
	}
	
	@GetMapping("/register")
	public String register(BookingSite bookingSite) {
		return "bookingSite/register";
	}

	// talvez tenha que mudar para post
	@GetMapping("/edit/{id}")
	public String preEdit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("bookingSite", bookingSiteService.findById(id));
		return "bookingSite/register";
	}

	@PostMapping("/edit")
	public String edit(@Valid BookingSite bookingSite, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "bookingSite/register";
		}

		bookingSiteService.save(bookingSite);
		attr.addFlashAttribute("success", "BookingSite edited successfully");
		return "redirect:/bookingSites/list";
	}

	@GetMapping("/remove/{id}")
	public String remove(@PathVariable("id") Long id, RedirectAttributes attr) {
		bookingSiteService.remove(id);
		attr.addFlashAttribute("success", "BookingSite removed successfully");
		return "redirect:/bookingSites/list";
	}


}
