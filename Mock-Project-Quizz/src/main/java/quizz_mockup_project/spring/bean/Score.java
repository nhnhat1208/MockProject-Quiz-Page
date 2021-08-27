package quizz_mockup_project.spring.bean;

public class Score {
	private String username;
	private Integer test_id;
	private Integer attemp;
	private Integer score;
	private String numsCorrectperTotal;
	
	public Score() {
		super();
	}
	
	public Score(String username, Integer test_id, Integer attemp, Integer score, String numsCorrectperTotal) {
		this.setUsername(username);
		this.setTest_id(test_id);
		this.setAttemp(attemp);
		this.setScore(score);
		this.setNumsCorrectperTotal(numsCorrectperTotal);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getTest_id() {
		return test_id;
	}

	public void setTest_id(Integer test_id) {
		this.test_id = test_id;
	}

	public Integer getAttemp() {
		return attemp;
	}

	public void setAttemp(Integer attemp) {
		this.attemp = attemp;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getNumsCorrectperTotal() {
		return numsCorrectperTotal;
	}

	public void setNumsCorrectperTotal(String numsCorrectperTotal) {
		this.numsCorrectperTotal = numsCorrectperTotal;
	}
}
