package com.co.prueba.parametra.demo.domain.repository;
import com.co.prueba.parametra.demo.domain.model.database.UserEntity;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository {


	void  saveEmployee(UserEntity UserEntity);
	Integer  getAll();

}
