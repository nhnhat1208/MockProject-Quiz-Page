package quizz_mockup_project.spring.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import quizz_mockup_project.spring.bean.UserAccount;
import quizz_mockup_project.spring.mapper.UserAccountMapper;

@Repository
@Transactional
public class DBUtils extends JdbcDaoSupport {

	@Autowired
	public DBUtils(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public UserAccount findUser(String username, String password) throws SQLException {

		String sql = "Select * from ACCOUNT a where a.USERNAME = ? and a.PASSWORD= ?";

		Object[] params = new Object[] { username, password };
		UserAccountMapper mapper = new UserAccountMapper();
		try {
			UserAccount account = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return account;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public UserAccount findUser(String username) throws SQLException {

		String sql = "Select * from ACCOUNT a where a.USERNAME = ? ";

		Object[] params = new Object[] { username };
		UserAccountMapper mapper = new UserAccountMapper();
		try {
			UserAccount account = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return account;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public void newUser(UserAccount account) throws SQLException {

		String sql = "INSERT INTO ? VALUE (?,?,?,?,?);";

		Object[] params = new Object[] { account.getUsername(), account.getPassword(), account.getDateBirth(),
				account.getEmail(), account.getJob(), account.getRole() };
		this.getJdbcTemplate().update(sql, params);
	}

}
