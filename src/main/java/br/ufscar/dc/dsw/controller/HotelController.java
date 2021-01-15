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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.classes.Hotel;
import br.ufscar.dc.dsw.service.spec.IHotelService;

@Controller
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping("/list")
	public String list(ModelMap model) {
		model.addAttribute("hotels", hotelService.findAll());
		return "hotel/list";
	}

	@PostMapping("/save")
	public String save(@Valid Hotel hotel, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "hotel/register";
		}
		hotel.setPassword(encoder.encode(hotel.getPassword()));
		hotelService.save(hotel);
		attr.addFlashAttribute("success", "Hotel inserted successfully");
		return "redirect:/hotels/list";
	}

	@GetMapping("/register")
	public String register(Hotel hotel) {
		return "hotel/register";
	}

	// talvez tenha que mudar para post
	@GetMapping("/edit/{id}")
	public String preEdit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("hotel", hotelService.findById(id));
		return "hotel/register";
	}

	@PostMapping("/edit")
	public String edit(@Valid Hotel hotel, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "hotel/register";
		}
		if (hotel.getPassword() != null) {

			hotel.setPassword(encoder.encode(hotel.getPassword()));
		}
		hotelService.save(hotel);
		attr.addFlashAttribute("success", "Hotel edited successfully");
		return "redirect:/hotels/list";
	}

	@GetMapping("/remove/{id}")
	public String remove(@PathVariable("id") Long id, RedirectAttributes attr) {
		hotelService.remove(id);
		attr.addFlashAttribute("success", "Hotel removed successfully");
		return "redirect:/hotels/list";
	}
	
	@GetMapping("/hotels/city")
	public String listAllByCity(@RequestParam(name="city") String city, ModelMap model) {
		System.out.println(city);
		model.addAttribute("hotels", hotelService.findAllByCity(city));
		return "redirect:hotels/list";
	}

}
