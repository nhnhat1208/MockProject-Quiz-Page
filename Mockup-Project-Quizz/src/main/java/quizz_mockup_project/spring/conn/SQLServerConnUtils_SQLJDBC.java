package quizz_mockup_project.spring.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnUtils_SQLJDBC {

	// Kết nối vào SQLServer.
	public static Connection getSQLServerConnection_SQLJDBC() throws ClassNotFoundException, SQLException {
		String hostName = "BESTIENHUYNH";
		String sqlInstanceName = "SQLEXPRESS01";
		String database = "mobileweb";
		String userName = "hhnam";
		String password = "12345";

		return getSQLServerConnection_SQLJDBC(hostName, sqlInstanceName, database, userName, password);
	}

	private static Connection getSQLServerConnection_SQLJDBC(String hostName, String sqlInstanceName, String database,
			String username, String password) throws ClassNotFoundException, SQLException {
	
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		String connectionURL = "jdbc:sqlserver://" + hostName + ":26780" + ";instance=" + sqlInstanceName + ";databaseName=" + database;
		Connection conn = DriverManager.getConnection(connectionURL, username, password);
		
		return conn;
	}

}