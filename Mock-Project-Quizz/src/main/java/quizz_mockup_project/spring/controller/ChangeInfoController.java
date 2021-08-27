package quizz_mockup_project.spring.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
public class ChangeInfoController {
	@Autowired
	ServletContext context;

	@Autowired
	private DBUtils dao;

	@RequestMapping(value = { "/changeInfo" }, method = RequestMethod.GET)
	public String loadPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object objUserBean = session.getAttribute("user");
		if (objUserBean == null) {
			response.sendRedirect("/login");
			return "login";
		}
		return "infochange";
	}

	@RequestMapping(value = { "/changeInfo" }, method = RequestMethod.POST)
	protected void addUser(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserAccount user = (UserAccount) session.getAttribute("user");
		
		response.setContentType("text/html;charset=UTF-8");
		String message = null;
		String username = user.getUsername();
		String password = request.getParameter("password");
		String newpassword = request.getParameter("newpassword");
		String dateBirth = request.getParameter("birthday");
		String email = request.getParameter("email");
		if (email.equals("")) email = user.getEmail();
		String job = request.getParameter("job");
		if (job.equals("")) job = user.getJob();
		String imagefile = request.getParameter("image");
		if (imagefile.equals("")) imagefile = user.getImage();
		Integer role = user.getRole();

		UserAccount account = new UserAccount(username, password, dateBirth, email, job, role, imagefile);
		try {
			int result = this.dao.updateInfo(account, newpassword);
			if (result == -1) response.getWriter().write("2"); // Not found
			else if (result == 0) response.getWriter().write("0"); // Wrong pass
			else if (result == 1) response.getWriter().write("1"); // Success
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("2"); // Unknown ERROR
			return;
		}

		return;

	}

	@PostMapping("/uploadChangedImage")
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
