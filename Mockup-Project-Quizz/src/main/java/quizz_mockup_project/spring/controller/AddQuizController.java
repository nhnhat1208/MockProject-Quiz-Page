package quizz_mockup_project.spring.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quizz_mockup_project.spring.bean.Category;
import quizz_mockup_project.spring.bean.Quiz;
import quizz_mockup_project.spring.bean.Test;
import quizz_mockup_project.spring.bean.UserAccount;
import quizz_mockup_project.spring.utils.DBUtils;

@Controller
public class AddQuizController {
	@Autowired
	private DBUtils dao;

	@RequestMapping(value = { "/add_quiz" }, method = RequestMethod.GET)
	public String loadPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object objUserBean = session.getAttribute("user");
		if (objUserBean == null) {
			return "login";
		} else {
			UserAccount user = (UserAccount) objUserBean;
			if (user.getRole() == 0) {
				return "quiz_add";
			} else {
				response.sendRedirect("/home");
				return "mainPage";
			}

		}
	}

	@RequestMapping(value = { "/addQuiz" }, method = RequestMethod.POST)
	protected void signup(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {

		String message = null;

		// String username =
		// AppUtils.getLoginedUser(request.getSession()).getUsername();
		UserAccount user = (UserAccount) request.getSession().getAttribute("user");
		if (user == null) {
			loadPage(request, response);
		}
		String username = user.getUsername();

		response.setContentType("text/html;charset=UTF-8");
		String topic = request.getParameter("topic");
		String name = request.getParameter("name");
		String list = request.getParameter("quizlist");
		JSONObject listquiz = new JSONObject(list);
		list = request.getParameter("rightanswerlist");
		JSONObject listrightanswer = new JSONObject(list);

		Category category = null;

		try {
			category = this.dao.findCategory(topic);
			if (category == null) {
				category = new Category(0, topic, "", "");
				this.dao.newCategory(category);
			}
			category = this.dao.findCategory(topic);
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("2");
			return;
		}

		Test test = new Test(0, topic, name, category.getId(), username);

		try {
			if (this.dao.findTest(test) != null) {
				response.getWriter().write("0"); // Test name exist
				return;
			}
			this.dao.newTest(test);
			test = this.dao.findTest(test);
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("2"); // Unknown ERROR
			return;
		}

		for (Integer i = 0; i < listquiz.length(); i++) {
			JSONObject quizObj = listquiz.getJSONObject(i.toString());

			String correctAnsw = null;
			String incorrectAnsw_1 = null;
			String incorrectAnsw_2 = null;
			String incorrectAnsw_3 = null;
			if (listrightanswer.getString(i.toString()).equals("Câu trả lời 1")) {
				correctAnsw = quizObj.getString("correctAnsw");
				incorrectAnsw_1 = quizObj.getString("incorrectAnsw_1");
				incorrectAnsw_2 = quizObj.getString("incorrectAnsw_2");
				incorrectAnsw_3 = quizObj.getString("incorrectAnsw_3");
			} else if (listrightanswer.getString(i.toString()).equals("Câu trả lời 2")) {
				incorrectAnsw_1 = quizObj.getString("correctAnsw");
				correctAnsw = quizObj.getString("incorrectAnsw_1");
				incorrectAnsw_2 = quizObj.getString("incorrectAnsw_2");
				incorrectAnsw_3 = quizObj.getString("incorrectAnsw_3");
			} else if (listrightanswer.getString(i.toString()).equals("Câu trả lời 3")) {
				incorrectAnsw_2 = quizObj.getString("correctAnsw");
				incorrectAnsw_1 = quizObj.getString("incorrectAnsw_1");
				correctAnsw = quizObj.getString("incorrectAnsw_2");
				incorrectAnsw_3 = quizObj.getString("incorrectAnsw_3");
			} else {
				incorrectAnsw_3 = quizObj.getString("correctAnsw");
				incorrectAnsw_1 = quizObj.getString("incorrectAnsw_1");
				incorrectAnsw_2 = quizObj.getString("incorrectAnsw_2");
				correctAnsw = quizObj.getString("incorrectAnsw_3");
			}

			Quiz quiz = new Quiz(0, test.getId(), quizObj.getString("question"), correctAnsw, incorrectAnsw_1,
					incorrectAnsw_2, incorrectAnsw_3);

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
