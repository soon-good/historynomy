package io.historynomy.serviceapi.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(){
		return "index";
	}

	@GetMapping("/chart")
	public String chart(){
		return "chart";
	}
}
