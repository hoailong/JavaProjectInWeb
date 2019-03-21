package DTO;

public class StudentDTO {
	private int id;
	private String name;
	private ProvinceDTO place;
	private String birth;
	private int gender;
	private float math;
	private float physical;
	private float chemistry;

	public StudentDTO() {
		super();
	}

	public StudentDTO(int id, String name, ProvinceDTO place, String birth, int gender, float math, float physical,
			float chemistry) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
		this.birth = birth;
		this.gender = gender;
		this.math = math;
		this.physical = physical;
		this.chemistry = chemistry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProvinceDTO getPlace() {
		return place;
	}

	public void setPlace(ProvinceDTO place) {
		this.place = place;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public float getMath() {
		return math;
	}

	public void setMath(float math) {
		this.math = math;
	}

	public float getPhysical() {
		return physical;
	}

	public void setPhysical(float physical) {
		this.physical = physical;
	}

	public float getChemistry() {
		return chemistry;
	}

	public void setChemistry(float chemistry) {
		this.chemistry = chemistry;
	}

	@Override
	public String toString() {
		return "StudentDTO2 [id=" + id + ", name=" + name + ", place=" + place.toString() + ", birth=" + birth + 
				", gender="  + gender + ", math=" + math + ", physical=" + physical + ", chemistry=" + chemistry + "]";
	}


}
