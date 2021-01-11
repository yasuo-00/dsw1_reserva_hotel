package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.classes.SaleOff;
import br.ufscar.dc.dsw.service.spec.ISaleOffService;

@Controller
@RequestMapping("/saleOff")
public class SaleOffController {
	
	@Autowired
	private ISaleOffService saleOffService;
	

	@GetMapping("/list")
	public String listAll(@RequestParam(value="hotelId", required=false) Long hotelId ,ModelMap model) {
		if(hotelId==null) {
			model.addAttribute("saleOffs", saleOffService.findAll());
		}else {
			model.addAttribute("saleOffs", saleOffService.findAllByHotel(hotelId));
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
		return "redirect:/saleOff/listAll";
	}
	
	@GetMapping("/register")
	public String register(SaleOff saleOff) {
		return "/saleOff/register";
	}

	// talvez tenha que mudar para post
	@GetMapping("/edit/{id}")
	public String preEdit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("SaleOff", saleOffService.findById(id));
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


}
