package quizz_mockup_project.spring.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import quizz_mockup_project.spring.filter.CookieFilter;
import quizz_mockup_project.spring.filter.JDBCFilter;
import quizz_mockup_project.spring.filter.SecurityFilter;

@Configuration
public class SecurityConfig {

	public static final String ROLE_ADMIN = "0";
	public static final String ROLE_TEACHER = "1";
	public static final String ROLE_STUDENT = "1";

	@Bean
	public FilterRegistrationBean<SecurityFilter> securityFilterRegistrationBean() {
		FilterRegistrationBean<SecurityFilter> registrationBean = new FilterRegistrationBean<SecurityFilter>();
		SecurityFilter securityFilter = new SecurityFilter();

		registrationBean.setFilter(securityFilter);
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(1); // set precedence
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean<JDBCFilter> jdbcFilterRegistrationBean() {
		FilterRegistrationBean<JDBCFilter> registrationBean = new FilterRegistrationBean<JDBCFilter>();
		JDBCFilter jdbcFilter = new JDBCFilter();

		registrationBean.setFilter(jdbcFilter);
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(2); // set precedence
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean<CookieFilter> cookieFilterRegistrationBean() {
		FilterRegistrationBean<CookieFilter> registrationBean = new FilterRegistrationBean<CookieFilter>();
		CookieFilter cookieFilter = new CookieFilter();

		registrationBean.setFilter(cookieFilter);
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(3); // set precedence
		return registrationBean;
	}

	// String: Role
	// List<String>: urlPatterns.
	private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

	static {
		init();
	}

	private static void init() {

		// Cấu hình vai trò cho "ADMIN".
		List<String> urlPatterns1 = new ArrayList<String>();

		urlPatterns1.add("");

		mapConfig.put(ROLE_ADMIN, urlPatterns1);

		// Cấu hình vai trò cho "TEACHER"
		List<String> urlPatterns2 = new ArrayList<String>();
		
		urlPatterns2.add("");

		mapConfig.put(ROLE_TEACHER, urlPatterns2);
		
		// Cấu hình vai trò cho "STUDENT"
		List<String> urlPatterns3 = new ArrayList<String>();
		
		urlPatterns3.add("");

		mapConfig.put(ROLE_STUDENT, urlPatterns3);
	}

	public static Set<String> getAllAppRoles() {
		return mapConfig.keySet();
	}

	public static List<String> getUrlPatternsForRole(String role) {
		return mapConfig.get(role);
	}

}