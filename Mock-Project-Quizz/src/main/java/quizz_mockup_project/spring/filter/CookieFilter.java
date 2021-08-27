package quizz_mockup_project.spring.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import quizz_mockup_project.spring.bean.UserAccount;
import quizz_mockup_project.spring.utils.DBUtils;
import quizz_mockup_project.spring.utils.AppUtils;

public class CookieFilter implements Filter {
	
	@Autowired
	private DBUtils dao;

	public CookieFilter() {
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		UserAccount userInSession = AppUtils.getLoginedUser(session);
		//
		if (userInSession != null) {
			session.setAttribute("COOKIE_CHECKED", "CHECKED");
			chain.doFilter(request, response);
			return;
		}

		Connection conn = AppUtils.getStoredConnection(request);

		String checked = (String) session.getAttribute("COOKIE_CHECKED");
		if (checked == null && conn != null) {
			String userName = AppUtils.getUserNameInCookie(req);
			try {
				UserAccount user = this.dao.findUser(userName);
				AppUtils.storeLoginedUser(session, user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			session.setAttribute("COOKIE_CHECKED", "CHECKED");
		}

		chain.doFilter(request, response);
	}

}
