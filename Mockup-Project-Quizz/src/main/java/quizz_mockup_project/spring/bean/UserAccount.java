package quizz_mockup_project.spring.bean;

public class UserAccount {
	private String username;
	private String password;
	private String dateBirth;
	private String email;
	private String job;
	private Integer role;

	public UserAccount() {
		super();
	}
	
	public UserAccount(String username, String password, String dateBirth, String email, String job, Integer role) {
		super();
		this.username = username;
		this.password = password;
		this.dateBirth = dateBirth;
		this.email = email;
		this.job = job;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

}
