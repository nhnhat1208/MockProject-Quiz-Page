package quizz_mockup_project.spring.utils;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quizz_mockup_project.spring.bean.Category;
import quizz_mockup_project.spring.bean.Quiz;
import quizz_mockup_project.spring.bean.Test;
import quizz_mockup_project.spring.bean.TestInfo;
import quizz_mockup_project.spring.bean.TestSuggest;
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

		String sql = "INSERT INTO [dbo].[Account] ([username], [password], [dateBirth], [email], [job], [role], [image]) VALUES (?,?,?,?,?,?,?);";

		Object[] params = new Object[] { account.getUsername(), account.getPassword(), account.getDateBirth(),
				account.getEmail(), account.getJob(), account.getRole(), account.getImage() };
		this.getJdbcTemplate().update(sql, params);
	}

	public void newTest(Test test) throws SQLException {

		String sql = "INSERT INTO [dbo].[Test] ([topic], [name], [category_id], [username]) VALUES (?,?,?,?);";

		Object[] params = new Object[] { test.getTopic(), test.getName(), test.getCategory_id(), test.getUsername() };
		this.getJdbcTemplate().update(sql, params);
	}
	
	public List<TestInfo> findTestInfo(String username) throws SQLException {

		String sql = "SELECT c.id,c.name,c.description,c.img_src,a.username,s.numsCorrectperTotal FROM Account a "
				+ "INNER JOIN Test t ON a.username = t.username "
				+ "INNER JOIN Category c ON t.category_id = c.id "
				+ "INNER JOIN Score s ON t.id = s.test_id "
				+ "WHERE a.username = ?;";
		
		Object[] params = new Object[] { username };
		TestInfoMapper mapper = new TestInfoMapper();
		try {
			List<TestInfo> testInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return testInfo;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public List<TestSuggest> findTestSuggest(String username) throws SQLException {
		String sql = "SELECT * FROM Category where id not in (select category_id from Test where username = ?);";
		
		Object[] params = new Object[] { username };
		TestSuggestMapper mapper = new TestSuggestMapper();
		try {
			List<TestSuggest> testSuggest = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return testSuggest;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public void newQuiz(Quiz quiz) throws SQLException {

		String sql = "INSERT INTO [dbo].[Quiz] ([test_id], [question], [correctAnsw], [incorrectAnsw_1], [incorrectAnsw_2], [incorrectAnsw_3]) VALUES (?,?,?,?,?,?);";

		Object[] params = new Object[] { quiz.getTest_id(), quiz.getQuestion(), quiz.getCorrectAnsw(),
				quiz.getIncorrectAnsw_1(), quiz.getIncorrectAnsw_2(), quiz.getIncorrectAnsw_3() };
		this.getJdbcTemplate().update(sql, params);
	}

	public Test findTest(Test test) throws SQLException {
		String sql = "SELECT * FROM [dbo].[Test] a WHERE a.name = ? AND a.username = ?;";

		Object[] params = new Object[] { test.getName(), test.getUsername() };
		TestMapper mapper = new TestMapper();
		try {
			Test result = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return result;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public void newCategory(Category category) throws SQLException {
		String sql = "INSERT INTO [dbo].[Category] ([name], [description], [img_src]) VALUES (?,?,?);";

		Object[] params = new Object[] {category.getName(), category.getDescription(), category.getImg_src()};
		this.getJdbcTemplate().update(sql, params);
	}

	public Category findCategory(String name) throws SQLException {
		String sql = "SELECT * FROM [dbo].[Category] a WHERE a.name = ?;";
		
		Object[] params = new Object[] { name };
		CategoryMapper mapper = new CategoryMapper();
		try {
			Category result = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return result;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
