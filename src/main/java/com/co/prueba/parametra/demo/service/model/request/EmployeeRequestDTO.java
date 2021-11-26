package com.co.prueba.parametra.demo.service.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeRequestDTO {
    private String name;
    private String lastname;
    private String document;
    private Date birthdate;
    private Date contractDate;
    private String charge;
    private Double salary;

    public EmployeeRequestDTO() {
    }

    public EmployeeRequestDTO(String name, String lastname, String document, Date birthdate, Date contractDate, String charge, Double salary) {
        this.name = name;
        this.lastname = lastname;
        this.document = document;
        this.birthdate = birthdate;
        this.contractDate = contractDate;
        this.charge = charge;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
