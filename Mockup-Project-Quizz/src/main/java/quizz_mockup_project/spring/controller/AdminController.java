package quizz_mockup_project.spring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quizz_mockup_project.spring.bean.UserAccount;

@Controller
public class AdminController {
	@RequestMapping(value = { "/adminInfo" }, method = RequestMethod.GET)
	public String loadPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object objUserBean = session.getAttribute("user");
		if (objUserBean == null) {
			response.sendRedirect("/login");
			return "login";
		} else {
			UserAccount user = (UserAccount) objUserBean;
			if (user.getRole() == 0) {
				return "admin_info";
			} else {
				response.sendRedirect("/home");
				return "mainPage";
			}
		}
	}

}
