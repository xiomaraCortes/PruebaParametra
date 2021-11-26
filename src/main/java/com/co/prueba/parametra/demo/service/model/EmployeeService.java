package com.co.prueba.parametra.demo.service.model;

import com.co.prueba.parametra.demo.service.model.request.EmployeeRequestDTO;
import com.co.prueba.parametra.demo.service.model.response.EmployeeResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public EmployeeResponseDTO executeNetworkMultiLayer(EmployeeRequestDTO employeeRequestDTO)  {
      return new EmployeeResponseDTO();
    }
}
