package quizz_mockup_project.spring.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;

public class UrlPatternUtils {

	private static boolean hasUrlPattern(ServletContext servletContext, String urlPattern) {
		List<String> urls = new ArrayList<String>();
		urls.add("/home");
		urls.add("/detail");
		urls.add("/cart");
		urls.add("/addProduct");
		
		if (urls.contains(urlPattern)) return true;

		Map<String, ? extends ServletRegistration> map = servletContext.getServletRegistrations();

		for (String servletName : map.keySet()) {
			ServletRegistration sr = map.get(servletName);

			Collection<String> mappings = sr.getMappings();
			if (mappings.contains(urlPattern)) {
				return true;
			}

		}
		return false;
	}

	// servletPath:
	// ==> /spath
	// ==> /spath/*
	// ==> *.ext
	// ==> /
	public static String getUrlPattern(HttpServletRequest request) {
		ServletContext servletContext = request.getServletContext();
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();

		String urlPattern = null;
		if (pathInfo != null) {
			urlPattern = servletPath + "/*";
			return urlPattern;
		}
		urlPattern = servletPath;

		boolean has = hasUrlPattern(servletContext, urlPattern);
		if (has) {
			return urlPattern;
		}
		int i = servletPath.lastIndexOf('.');
		if (i != -1) {
			String ext = servletPath.substring(i + 1);
			urlPattern = "*." + ext;
			has = hasUrlPattern(servletContext, urlPattern);

			if (has) {
				return urlPattern;
			}
		}
		return "/";
	}
}
