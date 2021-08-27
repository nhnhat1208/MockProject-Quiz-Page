package quizz_mockup_project.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quizz_mockup_project.spring.bean.TestInfo;
import quizz_mockup_project.spring.bean.UserAccount;
import quizz_mockup_project.spring.utils.DBUtils;

@Controller
public class LandingPageController {

	@Autowired
	private DBUtils dao;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String loadPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		UserAccount user = (UserAccount) session.getAttribute("user");
		if (user == null) {
			return "landingPage_guess";
		} else if (user.getRole() == 0) {
			response.sendRedirect("/adminInfo");
			return "admin_info";
		} else {
			List<TestInfo> quizInfo = null;
			try {
				quizInfo = this.dao.getAllTest();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("quizInfo", quizInfo);
			return "landingPage";
		}
	}

}

