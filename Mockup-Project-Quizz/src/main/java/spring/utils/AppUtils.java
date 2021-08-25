package quizz_mockup_project.spring.utils;

import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quizz_mockup_project.spring.bean.UserAccount;

public class AppUtils {
	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
	 
    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";

	private static int REDIRECT_ID = 0;

	private static final Map<Integer, String> id_uri_map = new HashMap<Integer, String>();
	private static final Map<String, Integer> uri_id_map = new HashMap<String, Integer>();
	
	// Lưu trữ Connection vào attribute của request.
    // Thông tin lưu trữ này chỉ tồn tại trong thời gian yêu cầu (request)
    // cho tới khi dữ liệu được trả về trình duyệt người dùng.
    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }
 
    // Lấy đối tượng Connection đã được lưu trữ trong attribute của request.
    public static Connection getStoredConnection(ServletRequest request) {
        Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
        return conn;
    }

	// Lưu trữ thông tin người dùng vào Session.
	public static void storeLoginedUser(HttpSession session, UserAccount loginedUser) {
		// Trên JSP có thể truy cập thông qua ${loginedUser}
		session.setAttribute("loginedUser", loginedUser);
	}
	
	// Đăng xuất thông tin người dùng khỏi session
	public static void logoutUser(HttpSession session) {
		session.removeAttribute("loginedUser");
	}

	// Lấy thông tin người dùng lưu trữ trong Session.
	public static UserAccount getLoginedUser(HttpSession session) {
		UserAccount loginedUser = (UserAccount) session.getAttribute("loginedUser");
		return loginedUser;
	}

	public static int storeRedirectAfterLoginUrl(HttpSession session, String requestUri) {
		Integer id = uri_id_map.get(requestUri);

		if (id == null) {
			id = REDIRECT_ID++;

			uri_id_map.put(requestUri, id);
			id_uri_map.put(id, requestUri);
			return id;
		}

		return id;
	}

	public static String getRedirectAfterLoginUrl(HttpSession session, int redirectId) {
		String url = id_uri_map.get(redirectId);
		if (url != null) {
			return url;
		}
		return null;
	}
	
	// Lưu thông tin người dùng vào Cookie.
    public static void storeUserCookie(HttpServletResponse response, UserAccount user) {
        System.out.println("Store user cookie");
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, user.getUsername());
        // 1 ngày (Đã đổi ra giây)
        cookieUserName.setMaxAge(24 * 60 * 60);
        response.addCookie(cookieUserName);
    }
 
    public static String getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
 
    // Xóa Cookie của người dùng
    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
        // 0 giây. (Cookie này sẽ hết hiệu lực ngay lập tức)
        cookieUserName.setMaxAge(0);
        response.addCookie(cookieUserName);
    }

}
