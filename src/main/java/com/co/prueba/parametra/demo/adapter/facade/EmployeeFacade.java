package com.co.prueba.parametra.demo.adapter.facade;

import com.co.prueba.parametra.demo.service.model.EmployeeService;
import com.co.prueba.parametra.demo.service.model.request.EmployeeRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeFacade {

    private EmployeeService employeeResponseDTO;

    @Autowired
    public EmployeeFacade(EmployeeService employeeService) {
        this.employeeResponseDTO = employeeService;
    }

    public Object executeQuery(EmployeeRequestDTO employeeRequestDTO){
        return this.employeeResponseDTO.executeNetworkMultiLayer(employeeRequestDTO);
    }
}
