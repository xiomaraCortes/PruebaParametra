package com.co.prueba.parametra.demo.domain.model.database;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -2463354084291480284L;

	@Id
	private Integer id;
	@Column(nullable = false , name = "name")
	private String name;
	@Column(nullable = false , name = "lastname")
	private String lastname;
	@Column(nullable = false , name = "document")
	private String document;
	@Column(nullable = false , name = "birthdate")
	private Date birthdate;
	@Column(nullable = false , name = "contractDate")
	private Date contractDate;
	@Column(nullable = false , name = "charge")
	private String charge;
	@Column(nullable = false , name = "salary")
	private Double salary;

	public UserEntity() {
	}

	public UserEntity(String name, String lastname, String document, Date birthdate, Date contractDate, String charge, Double salary) {
		super();
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
