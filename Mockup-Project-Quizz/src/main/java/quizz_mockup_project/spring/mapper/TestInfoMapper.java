package quizz_mockup_project.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import quizz_mockup_project.spring.bean.TestInfo;

public class TestInfoMapper implements RowMapper<List<TestInfo>>{

	@Override
	public List<TestInfo> mapRow(ResultSet rs, int rowNum) throws SQLException {
		List<TestInfo> list = new ArrayList<TestInfo>();
		Integer id = rs.getInt("ID");
		String name = rs.getString("NAME");
		String description = rs.getString("DESCRIPTION");
		String image = rs.getString("IMG_SRC");
        String userName = rs.getString("USERNAME");
        String numsCorrectperTotal = rs.getString("NUMSCORRECTPERTOTAL");
        
        TestInfo testInfo = new TestInfo(id, name, description, image, userName,numsCorrectperTotal);
        list.add(testInfo);
        while(rs.next()) {
        	id = rs.getInt("ID");
    		name = rs.getString("NAME");
    		description = rs.getString("DESCRIPTION");
    		image = rs.getString("IMG_SRC");
            userName = rs.getString("USERNAME");
            numsCorrectperTotal = rs.getString("NUMSCORRECTPERTOTAL");
            
            testInfo = new TestInfo(id, name, description, image, userName,numsCorrectperTotal);
            list.add(testInfo);
        }
        return list;
	}

}
