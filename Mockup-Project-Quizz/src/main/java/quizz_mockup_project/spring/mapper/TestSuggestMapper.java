package quizz_mockup_project.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import quizz_mockup_project.spring.bean.TestSuggest;

public class TestSuggestMapper implements RowMapper<List<TestSuggest>>{

	@Override
	public List<TestSuggest> mapRow(ResultSet rs, int rowNum) throws SQLException {
		List<TestSuggest> list = new ArrayList<TestSuggest>();
		Integer id = rs.getInt("ID");
		String name = rs.getString("NAME");
		String description = rs.getString("DESCRIPTION");
		String image = rs.getString("IMG_SRC");
        
		TestSuggest testSuggest = new TestSuggest(id, name, description, image);
        list.add(testSuggest);
        while(rs.next()) {
        	id = rs.getInt("ID");
    		name = rs.getString("NAME");
    		description = rs.getString("DESCRIPTION");
    		image = rs.getString("IMG_SRC");
            
            testSuggest = new TestSuggest(id, name, description, image);
            list.add(testSuggest);
        }
        return list;
	}

}
