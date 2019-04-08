package it1.studentmanagement.bus;

import java.util.List;

import it1.studentmanagement.dto.ProvinceDTO;

public interface IProvinceBUS {
	List<ProvinceDTO> findAll();
	String insert(String name);
	String update(int id, String name);
	String delete(int id);
	boolean checkConstant(String name);
 }
