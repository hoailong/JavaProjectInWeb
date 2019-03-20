package DAO;

import java.util.List;

import DTO.ProvinceDTO;

public interface IProvinceDAO {
	public List<ProvinceDTO> showProvince();
	public boolean insertProvince(ProvinceDTO province);
	public boolean updateProvince(ProvinceDTO province, int provinceId);
	public boolean deleteProvince(int provinceId);
}
