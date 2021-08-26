package quizz_mockup_project.spring.bean;

public class TestInfo {
	private Integer id;
	private String name;
	private String description;
	private String image;
	private String username;
	private String numsCorrectperTotal;
	
	public TestInfo() {
		super();
	}
	
	public TestInfo(Integer id, String name, String description,String image, String username,String numsCorrectperTotal) {
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
		this.setImage(image);
		this.setUsername(username);
		this.setNumsCorrectperTotal(numsCorrectperTotal);
	}

	private void setNumsCorrectperTotal(String numsCorrectperTotal2) {
		this.numsCorrectperTotal = numsCorrectperTotal2;
	}
	
	public String getNumsCorrectperTotal() {
		return numsCorrectperTotal;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
