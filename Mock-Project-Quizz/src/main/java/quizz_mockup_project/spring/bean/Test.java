package quizz_mockup_project.spring.bean;

public class Test {
	private Integer id;
	private String topic;
	private String name;
	private Integer category_id;
	private String username;
	
	public Test() {
		super();
	}
	
	public Test(Integer id, String topic, String name, Integer category_id, String username) {
		this.setId(id);
		this.setTopic(topic);
		this.setName(name);
		this.setCategory_id(category_id);
		this.setUsername(username);
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
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

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
