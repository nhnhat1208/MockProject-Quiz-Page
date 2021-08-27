package quizz_mockup_project.spring.bean;

public class Category {
	private Integer id;
	private String name;
	private String description;
	private String img_src;
	
	public Category() {
		super();
	}
	
	public Category(Integer id, String name, String description, String img_src) {
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
		this.setImg_src(img_src);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getImg_src() {
		return img_src;
	}

	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}
}
