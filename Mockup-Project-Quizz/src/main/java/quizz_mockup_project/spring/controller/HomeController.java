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
public class HomeController {
	@Autowired
	private DBUtils dao;
	
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String loadPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object objUserBean = session.getAttribute("user");
		if (objUserBean == null) {
			response.sendRedirect("/login");
			return "login";
		} else {
			
			UserAccount user = (UserAccount) objUserBean;
			
			if (user.getRole() == 0) {
				System.out.println("0");
				response.sendRedirect("/adminInfo");
				return "admin_info";
			} else {
				
				UserAccount userInfo = null;
				List<TestInfo> testInfo = null;
				List<TestSuggest> testSuggest = null;
				
				try {
					userInfo = this.dao.findUser(user.getUsername());
					System.out.println(userInfo);
					testInfo = this.dao.findHistory(user.getUsername());
					System.out.println(testInfo);
					testSuggest = this.dao.findTestSuggest(user.getUsername());
					System.out.println(testSuggest);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				System.out.println(testSuggest);
				request.setAttribute("testInfo", testInfo);
				request.setAttribute("testSuggest", testSuggest);
				request.setAttribute("userInfo", userInfo);
				
				return "mainPage";
				}
			}
	}
}