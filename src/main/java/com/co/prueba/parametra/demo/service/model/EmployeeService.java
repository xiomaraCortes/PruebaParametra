package com.co.prueba.parametra.demo.service.model;

import com.co.prueba.parametra.demo.adapter.api.model.BusinessException;
import com.co.prueba.parametra.demo.service.model.request.EmployeeRequestDTO;
import com.co.prueba.parametra.demo.service.model.response.EmployeeResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;


@Service
public class EmployeeService {

    public EmployeeResponseDTO executeNetworkMultiLayer(EmployeeRequestDTO employeeRequestDTO) throws JsonProcessingException, BusinessException {
        checkItem(employeeRequestDTO.getName());
        checkItem(employeeRequestDTO.getLastname());
        checkItem(employeeRequestDTO.getDocument());
        checkItem(employeeRequestDTO.getCharge());
        checkAge(employeeRequestDTO.getBirthdate());
        return new EmployeeResponseDTO( getDifferenceTime(employeeRequestDTO.getContractDate()), getDifferenceTime(employeeRequestDTO.getBirthdate()));
    }

    private String getDifferenceTime(Date time) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        long years = ChronoUnit.YEARS.between(LocalDate.parse(dateFormat.format(time)),
                LocalDate.parse(dateFormat.format(new Date())));
        long months = ChronoUnit.MONTHS.between(LocalDate.parse(dateFormat.format(time)),
                LocalDate.parse(dateFormat.format(new Date())));
        long days = ChronoUnit.DAYS.between(LocalDate.parse(dateFormat.format(time)),
                LocalDate.parse(dateFormat.format(new Date())));
        return years +"," +months+","+days;
    }

    private  void checkItem(Object field) throws BusinessException {
          if (checkNotNull(field) != null && (field instanceof String && ((String) field).isEmpty())) {
              throw new BusinessException("Por favor revisar los campos digitados");
          }
    }

    private  void checkAge(Date time) throws BusinessException {
        Calendar calendarActual = Calendar.getInstance();
        calendarActual.setTime(new Date());

        Calendar calendarBefore = Calendar.getInstance();
        calendarBefore.setTime(time);


        if(calendarActual.get(calendarActual.YEAR)- calendarBefore.get(calendarBefore.YEAR) < 18) {
            throw new BusinessException("Debe ser mayor de edad");
        }
    }
}
