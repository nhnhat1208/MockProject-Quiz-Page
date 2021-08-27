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

import quizz_mockup_project.spring.bean.Score;
import quizz_mockup_project.spring.bean.TestInfo;
import quizz_mockup_project.spring.bean.TestSuggest;
import quizz_mockup_project.spring.bean.UserAccount;
import quizz_mockup_project.spring.utils.DBUtils;

@Controller
public class QuizEntranceController {
	
	@Autowired
	private DBUtils dao;

	@RequestMapping(value = { "/quiz_entrance" }, method = RequestMethod.GET)
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
				
				String test_id = request.getParameter("test_id");
				request.setAttribute("test_id", test_id);
				
				Score bestTest = this.dao.findBestScore(user.getUsername(), Integer.parseInt(test_id));
				
				if (bestTest == null) request.setAttribute("best_score", "Không có bài kiểm tra được thực hiện");
				else request.setAttribute("best_score", bestTest.getScore());
				
				return "quizEntrance";
				}
			}
		
	}

}
