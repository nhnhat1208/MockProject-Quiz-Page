package quizz_mockup_project.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import quizz_mockup_project.spring.bean.Test;

public class TestMapper implements RowMapper<Test> {

	@Override
	public Test mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer id = rs.getInt("ID");
		String topic = rs.getString("TOPIC");
		String name = rs.getString("NAME");
		Integer category_id = rs.getInt("CATEGORY_ID");
		String username = rs.getString("USERNAME");

		return new Test(id, topic, name, category_id, username);
	}

}
