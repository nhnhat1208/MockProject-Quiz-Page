package quizz_mockup_project.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import quizz_mockup_project.spring.bean.Category;

public class CategoryMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer id = rs.getInt("ID");
		String name = rs.getString("NAME");
		String description = rs.getString("DESCRIPTION");
		String img_src = rs.getString("IMG_SRC");

		return new Category(id, name, description, img_src);
	}

}
