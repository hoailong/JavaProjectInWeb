package it1.studentmanagement.dto;

public class ProvinceDTO {
	private String name;
	private int id;
	
	public ProvinceDTO() {
		super();
	}
	
	public ProvinceDTO(String name, int provinceid) {
		super();
		this.name = name;
		this.id = provinceid;
	}
	
	

	public ProvinceDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int provinceid) {
		this.id = provinceid;
	}

	@Override
	public String toString() {
		return "ProvinceDTO [name=" + name + ", provinceid=" + id + "]";
	}
	
	
}
