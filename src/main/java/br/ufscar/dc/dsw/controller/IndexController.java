package br.ufscar.dc.dsw.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.classes.User;
import br.ufscar.dc.dsw.security.UserAccount;
import br.ufscar.dc.dsw.service.spec.IUserService;

@Controller
public class IndexController {
	
	private IUserService userService;

	@GetMapping("/")
	public String root() {
		return "home";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

//	@GetMapping("/sidebar")
//	public String sidebar(Model model, @AuthenticationPrincipal UserAccount currentUser) {
//		User user = userService.findById(currentUser.getId());
//		System.out.println(user.getId());
//		model.addAttribute("currentUserId", user);
//		return "sidebar";
//	}
}
