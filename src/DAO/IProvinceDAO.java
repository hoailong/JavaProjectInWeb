package DAO;

import java.util.List;

import DTO.ProvinceDTO;

public interface IProvinceDAO {
	public List<ProvinceDTO> showProvince();
	public boolean insertProvince(ProvinceDTO prv);
	public boolean updateProvince(ProvinceDTO prv, int code);
	public boolean deleteProvince(int id);
}
