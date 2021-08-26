package quizz_mockup_project.spring.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
import quizz_mockup_project.spring.bean.Score;
import quizz_mockup_project.spring.bean.Test;
import quizz_mockup_project.spring.bean.UserAccount;
import quizz_mockup_project.spring.utils.DBUtils;

@Controller
public class QuizPageController {
	@Autowired
	private DBUtils dao;

	@RequestMapping(value = { "/quizpage" }, method = RequestMethod.GET)
	public String loadPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = request.getSession();
		Object objUserBean = session.getAttribute("user");
		if (objUserBean == null) {
			return "login";
		}
		
		Integer quiz_id = null;

		if (request.getParameter("quiz_id") != null) {
			quiz_id = Integer.parseInt(request.getParameter("quiz_id"));
		}
		
		Integer test_id = Integer.parseInt(request.getParameter("test_id"));

		List<Quiz> quizlist = this.dao.loadQuizes(test_id);

		if (quizlist == null) {
			model.addAttribute("question", "No question in this test");
		} else {
			if (quiz_id == null) {
				model.addAttribute("quiz_id", quizlist.get(0).getId());
				model.addAttribute("question", quizlist.get(0).getQuestion());
				model.addAttribute("answer", quizlist.get(0).randomAns());
				request.getSession().setAttribute("correctedAnswers", 0);
			} else {
				for (Integer i = 0; i < quizlist.size(); i++) {
					if (quizlist.get(i).getId().equals(quiz_id)) {
						model.addAttribute("quiz_id", quizlist.get(i).getId());
						model.addAttribute("question", quizlist.get(i).getQuestion());
						model.addAttribute("answer", quizlist.get(i).randomAns());
						break;
					}
				}
			}
		}
		
		return "quizPage";
	}

	@RequestMapping(value = { "/answerQuestion" }, method = RequestMethod.POST)
	protected void markQuestion(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {

		String message = null;

		// String username =
		// AppUtils.getLoginedUser(request.getSession()).getUsername();
		UserAccount user = (UserAccount) request.getSession().getAttribute("user");
		String username = user.getUsername();

		response.setContentType("text/html;charset=UTF-8");
		String quiz_id = request.getParameter("quiz_id");
		String answer = request.getParameter("answer");

		List<Quiz> quizlist = this.dao.loadQuizes(8);
		Quiz nextquiz = new Quiz();
		Integer correctedAnswers = 0;

		for (Integer i = 0; i < quizlist.size(); i++) {
			if (quizlist.get(i).getId().equals(Integer.parseInt(quiz_id))) {
				if (quizlist.get(i).getCorrectAnsw().equals(answer)) {
					correctedAnswers = (Integer) request.getSession().getAttribute("correctedAnswers");
					request.getSession().setAttribute("correctedAnswers", correctedAnswers + 1);
				}
				if (i + 1 == quizlist.size()) {
					Score score = new Score(username, nextquiz.getId(), 1, (correctedAnswers + 1) / quizlist.size(), "" + correctedAnswers + '/' + quizlist.size());
					try {
						this.dao.insertScore(score);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					response.getWriter().write("-1"); // Done test
					return;
				}
				nextquiz = quizlist.get(i + 1);
				break;
			}
		}

		response.getWriter().write(nextquiz.getId());

		return;

	}
}
