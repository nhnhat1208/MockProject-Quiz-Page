package quizz_mockup_project.spring.bean;

public class TestSuggest {
	private Integer id;
	private String name;
	private String description;
	private String image;
	
	public TestSuggest() {
		super();
	}
	
	public TestSuggest(Integer id, String name, String description,String image) {
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
		this.setImage(image);
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

