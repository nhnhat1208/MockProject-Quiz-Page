package quizz_mockup_project.spring.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quizz_mockup_project.spring.bean.UserAccount;
import quizz_mockup_project.spring.utils.DBUtils;

@Controller
public class SingUpController {
	@Autowired
	private DBUtils dao;

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public String loadPage() {
		return "signUp";
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
	protected String signup(HttpServletRequest request, Model model)
			throws ServletException, IOException {

		String message = null;

		// lấy cái thuộc tính của user
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String dateBirth = request.getParameter("birthday");
		String email = request.getParameter("email");
		String job = request.getParameter("job");
		String imagefile = request.getParameter("image-file").toString();
		// imagefile = imagefile.replace("\\", "/");
		// String[] imageUrl = imagefile.split("/");
		// imagefile = imageUrl[imageUrl.length - 1];
		Integer role = 1;
		
		if (!password.equals(repassword)) {
			message = "Re-enter password not match";
			model.addAttribute("message", message);
			return "signUp";
		}
		
		try {
			if (this.dao.findUser(username) != null) {
				message = "User already existed";
				model.addAttribute("message", message);
				return "signUp";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		UserAccount account = new UserAccount(username, password, dateBirth, email, job, role);
		try {
			this.dao.newUser(account); // thêm product vào database
		} catch (SQLException e) {
			e.printStackTrace();

			message = "Sign up not successful";
			model.addAttribute("message", message);

			return "signUp";
		}

		message = "Sign up successful";
		model.addAttribute("message", message);

		return "signUp";

	}
}
