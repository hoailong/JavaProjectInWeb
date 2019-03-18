package DTO;

public class ProvinceDTO {
	private String name;
	private int code;
	
	public ProvinceDTO() {
		super();
	}
	
	public ProvinceDTO(String name, int code) {
		super();
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ProvinceDTO [name=" + name + ", code=" + code + "]";
	}
	
	
}
