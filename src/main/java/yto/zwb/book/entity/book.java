package yto.zwb.book.entity;

public class book {
	private Integer  id;
	private String name;
	private String writer;
	private String introduction;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	@Override
	public String toString() {
		return "book [id=" + id + ", name=" + name + ", writer=" + writer + ", introduction=" + introduction + "]";
	}

	
	
	

}
