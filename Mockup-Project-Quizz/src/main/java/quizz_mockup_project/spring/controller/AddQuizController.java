package quizz_mockup_project.spring.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import quizz_mockup_project.spring.bean.Quiz;
import quizz_mockup_project.spring.bean.Test;
import quizz_mockup_project.spring.bean.UserAccount;
import quizz_mockup_project.spring.utils.AppUtils;
import quizz_mockup_project.spring.utils.DBUtils;

@Controller
public class AddQuizController {
	@Autowired
	private DBUtils dao;

	@RequestMapping(value = { "/add_quiz" }, method = RequestMethod.GET)
	public String loadPage() {
		return "quiz_add";
	}

	@RequestMapping(value = { "/addQuiz" }, method = RequestMethod.POST)
	protected void signup(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {

		String message = null;
		
		//String username = AppUtils.getLoginedUser(request.getSession()).getUsername();

		String username = "hhnam";
		
		response.setContentType("text/html;charset=UTF-8");
		String topic = request.getParameter("topic");
		String name = request.getParameter("name");
		String list = request.getParameter("quizlist");
		JSONObject listquiz = new JSONObject(list);

		Test test = new Test(0, topic, name, 1, username);

		try {
			this.dao.newTest(test);
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("2"); // Unknown ERROR
			return;
		}

		for (Integer i = 0; i < listquiz.length(); i++) {
			JSONObject quizObj = listquiz.getJSONObject(i.toString());
			Quiz quiz = new Quiz(0, 0, quizObj.getString("question"), quizObj.getString("correctAnsw"),
					quizObj.getString("incorrectAnsw_1"), quizObj.getString("incorrectAnsw_2"),
					quizObj.getString("incorrectAnsw_3"));

			try {
				this.dao.newQuiz(quiz);
			} catch (SQLException e) {
				e.printStackTrace();
				response.getWriter().write("2"); // Unknown ERROR
				return;
			}
		}

		response.getWriter().write("1"); // Success
		model.addAttribute("message", message);

		return;

	}
}
