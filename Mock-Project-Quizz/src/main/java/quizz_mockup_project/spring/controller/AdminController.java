package quizz_mockup_project.spring.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quizz_mockup_project.spring.bean.TestInfo;
import quizz_mockup_project.spring.bean.TestSuggest;
import quizz_mockup_project.spring.bean.UserAccount;
import quizz_mockup_project.spring.utils.DBUtils;

@Controller
public class AdminController {
	@Autowired
	private DBUtils dao;
	
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
				UserAccount userInfo = null;
				List<TestInfo> quizInfo = null;
				try {
					userInfo = this.dao.findUser(user.getUsername());
					quizInfo = this.dao.findQuizInfo(user.getUsername());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("quizInfo", quizInfo);
				request.setAttribute("userInfo", userInfo);

				return "admin_info";
			} else {
				response.sendRedirect("/home");
				return "mainPage";
			}
		}
		
	}

}
