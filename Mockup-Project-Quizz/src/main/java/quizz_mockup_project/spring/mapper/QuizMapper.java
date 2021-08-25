package quizz_mockup_project.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import quizz_mockup_project.spring.bean.Quiz;

public class QuizMapper implements RowMapper<Quiz> {

	@Override
	public Quiz mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer id = rs.getInt("ID");
		Integer test_id = rs.getInt("TEST_ID");
		String question = rs.getString("QUESTION");
		String correctAnsw = rs.getString("CORRECTANSW");
		String incorrectAnsw_1 = rs.getString("INCORRECTANSW_1");
		String incorrectAnsw_2 = rs.getString("INCORRECTANSW_2");
		String incorrectAnsw_3 = rs.getString("INCORRECTANSW_3");

		return new Quiz(id, test_id, question, correctAnsw, incorrectAnsw_1, incorrectAnsw_2, incorrectAnsw_3);
	}

}
