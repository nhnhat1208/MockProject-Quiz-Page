package quizz_mockup_project.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SingUpController {
	@RequestMapping("/signup")
	public String loadPage() {
		return "signUp";
	}
}
