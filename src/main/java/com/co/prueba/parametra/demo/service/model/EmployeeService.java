package com.co.prueba.parametra.demo.service.model;

import com.co.prueba.parametra.demo.service.model.request.EmployeeRequestDTO;
import com.co.prueba.parametra.demo.service.model.response.EmployeeResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;


@Service
public class EmployeeService {

    public EmployeeResponseDTO executeNetworkMultiLayer(EmployeeRequestDTO employeeRequestDTO) throws JsonProcessingException {
        checkItem(employeeRequestDTO.getName());
        checkItem(employeeRequestDTO.getLastname());
        checkItem(employeeRequestDTO.getDocument());
        checkItem(employeeRequestDTO.getCharge());
        return new EmployeeResponseDTO();
    }

    private  void checkItem(Object field){
          if (checkNotNull(field) != null && (field instanceof String && ((String) field).isEmpty())) {
            throw new NullPointerException();
          }
    }
}
