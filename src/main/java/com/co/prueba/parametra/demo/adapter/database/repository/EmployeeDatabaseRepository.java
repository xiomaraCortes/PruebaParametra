package com.co.prueba.parametra.demo.adapter.database.repository;

import com.co.prueba.parametra.demo.adapter.database.EmployeeRepositoryJPA;
import com.co.prueba.parametra.demo.domain.repository.UserRepository;
import com.co.prueba.parametra.demo.domain.model.database.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDatabaseRepository implements UserRepository {


	private final EmployeeRepositoryJPA employeeRepositoryJPA;

	@Autowired
	public EmployeeDatabaseRepository(EmployeeRepositoryJPA employeeRepositoryJPA) {
		this.employeeRepositoryJPA = employeeRepositoryJPA;
	}

	@Override
	public void  saveEmployee(UserEntity UserEntity) {
		this.employeeRepositoryJPA.save(UserEntity);
	}

	@Override
	public Integer getAll() {
		List<UserEntity> users= this.employeeRepositoryJPA.findAll();
		return users.isEmpty() ? 1: users.size() + 1;
	}
}
