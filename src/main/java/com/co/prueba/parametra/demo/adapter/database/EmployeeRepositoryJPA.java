package com.co.prueba.parametra.demo.adapter.database;

import com.co.prueba.parametra.demo.domain.model.database.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositoryJPA extends JpaRepository<UserEntity, Integer> {

}
