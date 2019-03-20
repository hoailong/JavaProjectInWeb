package DTO;

public class ProvinceDTO {
	private String name;
	private int Id;
	
	public ProvinceDTO() {
		super();
	}
	
	public ProvinceDTO(String name, int provinceId) {
		super();
		this.name = name;
		this.Id = provinceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return Id;
	}

	public void setId(int provinceId) {
		this.Id = provinceId;
	}

	@Override
	public String toString() {
		return "ProvinceDTO [name=" + name + ", provinceId=" + Id + "]";
	}
	
	
}
