package quizz_mockup_project.spring.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Quiz {
	private Integer id;
	private Integer test_id;
	private String question;
	private String correctAnsw;
	private String incorrectAnsw_1;
	private String incorrectAnsw_2;
	private String incorrectAnsw_3;

	public Quiz() {
		super();
	}

	public Quiz(Integer id, Integer test_id, String question, String correctAnsw, String incorrectAnsw_1,
			String incorrectAnsw_2, String incorrectAnsw_3) {
		this.setId(id);
		this.setTest_id(test_id);
		this.setQuestion(question);
		this.setCorrectAnsw(correctAnsw);
		this.setIncorrectAnsw_1(incorrectAnsw_1);
		this.setIncorrectAnsw_2(incorrectAnsw_2);
		this.setIncorrectAnsw_3(incorrectAnsw_3);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTest_id() {
		return test_id;
	}

	public void setTest_id(Integer test_id) {
		this.test_id = test_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrectAnsw() {
		return correctAnsw;
	}

	public void setCorrectAnsw(String correctAnsw) {
		this.correctAnsw = correctAnsw;
	}

	public String getIncorrectAnsw_1() {
		return incorrectAnsw_1;
	}

	public void setIncorrectAnsw_1(String incorrectAnsw_1) {
		this.incorrectAnsw_1 = incorrectAnsw_1;
	}

	public String getIncorrectAnsw_2() {
		return incorrectAnsw_2;
	}

	public void setIncorrectAnsw_2(String incorrectAnsw_2) {
		this.incorrectAnsw_2 = incorrectAnsw_2;
	}

	public String getIncorrectAnsw_3() {
		return incorrectAnsw_3;
	}

	public void setIncorrectAnsw_3(String incorrectAnsw_3) {
		this.incorrectAnsw_3 = incorrectAnsw_3;
	}
	
	public List<String> randomAns() {
		List<String> ans = new ArrayList<String>();
		ans.add(correctAnsw);
		ans.add(incorrectAnsw_1);
		ans.add(incorrectAnsw_2);
		ans.add(incorrectAnsw_3);
		Collections.shuffle(ans);
		return ans;
	}
}
