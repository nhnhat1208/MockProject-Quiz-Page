package quizz_mockup_project.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import quizz_mockup_project.spring.bean.UserAccount;

public class UserAccountMapper implements RowMapper<UserAccount> {

	@Override
	public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {

		String username = rs.getString("USERNAME");
		String password = rs.getString("PASSWORD");
		String dateBirth = rs.getString("DATEBIRTH");
		String email = rs.getString("EMAIL");
		String job = rs.getString("JOB");
		int role = rs.getInt("ROLE");
		String image = rs.getString("IMAGE");

		return new UserAccount(username, password, dateBirth, email, job, role, image);
	}

}
