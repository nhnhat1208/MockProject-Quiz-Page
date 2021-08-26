package quizz_mockup_project.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import quizz_mockup_project.spring.bean.Score;

public class ScoreMapper implements RowMapper<Score> {

	@Override
	public Score mapRow(ResultSet rs, int rowNum) throws SQLException {

		String username = rs.getString("USERNAME");
		Integer test_id = rs.getInt("TEST_ID");
		Integer attemp = rs.getInt("ATTEMP");
		Integer score = rs.getInt("SCORE");
		String numsCorrectperTotal = rs.getString("numsCorrectperTotal");

		return new Score(username, test_id, attemp, score, numsCorrectperTotal);
	}

}
