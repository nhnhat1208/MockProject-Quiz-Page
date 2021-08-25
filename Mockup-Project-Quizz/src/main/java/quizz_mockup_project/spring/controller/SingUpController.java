package quizz_mockup_project.spring.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quizz_mockup_project.spring.bean.UserAccount;
import quizz_mockup_project.spring.utils.DBUtils;

@Controller
public class SingUpController {
	@Autowired
	ServletContext context;

	@Autowired
	private DBUtils dao;

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public String loadPage() {
		return "signUp";
	}

	@RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
	protected void addUser(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String message = null;

		String username = request.getParameter("username");
		String password = request.getParameter("password");
<<<<<<< HEAD
		String dateBirth = request.getParameter("birthday");
		String email = request.getParameter("email");
		String job = request.getParameter("job");
		String imagefile = request.getParameter("image");
		Integer role = 1;

=======
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
		
>>>>>>> f16d59f05fec98067918fa36080cbfc59c6c1ae0
		try {
			if (this.dao.findUser(username) != null) {
				response.getWriter().write("0"); // 0 mean Username đã tồn tại
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("2"); // Unknown ERROR
			return;
		}

		UserAccount account = new UserAccount(username, password, dateBirth, email, job, role, imagefile);
		try {
			this.dao.newUser(account);
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("2"); // Unknown ERROR
			return;
		}

		response.getWriter().write("1"); // Success
		model.addAttribute("message", message);

		return;

	}

	@PostMapping("/uploadImage")
	void uploadImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		final String UPLOAD_DIRECTORY = context.getRealPath("") + File.separator + "images";
		if (ServletFileUpload.isMultipartContent(request)) {

			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				System.out.println(UPLOAD_DIRECTORY + multiparts);

				for (FileItem item : multiparts) {
					System.out.println(UPLOAD_DIRECTORY + item);

					if (!item.isFormField()) {
						File fileSaveDir = new File(UPLOAD_DIRECTORY);
						if (!fileSaveDir.exists()) {
							fileSaveDir.mkdir();
						}
						String name = new File(item.getName()).getName();
						item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
					}
				}

			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}
}
