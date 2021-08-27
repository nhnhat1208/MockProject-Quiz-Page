package quizz_mockup_project.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import quizz_mockup_project.spring.bean.UserAccount;
import quizz_mockup_project.spring.utils.DBUtils;

@Controller
public class LoginController {

	@Autowired
	private DBUtils dao;

	@RequestMapping("/login")
	public String loadPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object objUserBean = session.getAttribute("user");
		if (objUserBean == null) {
			return "login";
		} else {
			return "landingPage";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object objUserBean = session.getAttribute("user");
		if (objUserBean != null) {
			session.setAttribute("user", null);
		}
		response.sendRedirect("/login");
		return "login";

	}

	@PostMapping("/checkLogin")
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String name = request.getParameter("user");
			String password = request.getParameter("password");

			UserAccount user = this.dao.findUser(name, password);
			if (user != null) {
				response.getWriter().write("1");
				HttpSession session = request.getSession();
				Object objUserBean = session.getAttribute("user");

				if (objUserBean == null) {
					session.setAttribute("user", user);
				}

			} else {
				response.getWriter().write("0");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
