package com.co.prueba.parametra.demo.domain.model.response;

public class EmployeeResponseDTO {

    private String contract;
    private String age;

    public EmployeeResponseDTO(String contract, String age) {
        this.contract = contract;
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
}
