package quizz_mockup_project.spring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quizz_mockup_project.spring.utils.DBUtils;

@Controller
public class QuizEntranceController {
	
	@Autowired
	private DBUtils dao;

	@RequestMapping(value = { "/quiz_entrance" }, method = RequestMethod.GET)
	public String loadPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String test_id = request.getParameter("test_id");
		request.setAttribute("test_id", test_id);
		return "quizEntrance";
	}

}
