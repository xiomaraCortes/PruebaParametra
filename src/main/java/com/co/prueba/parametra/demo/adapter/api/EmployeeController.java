package com.co.prueba.parametra.demo.adapter.api;

import com.co.prueba.parametra.demo.adapter.ApiConst;
import com.co.prueba.parametra.demo.adapter.api.model.BusinessException;
import com.co.prueba.parametra.demo.adapter.facade.EmployeeFacade;
import com.co.prueba.parametra.demo.domain.model.request.EmployeeRequestDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = ApiConst.EMPLOYEE_PATH)
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })

public class EmployeeController {
    private Gson gson;
    private EmployeeFacade employeeFacade;
    //Linea del contructor JSON

    @Autowired
    public EmployeeController(Gson gson, EmployeeFacade employeeFacade) {
        this.gson = gson;
        this.employeeFacade = employeeFacade;
    }



    //Se crea el controlador que llama al servicio 
    @RequestMapping(value = "/getDataEmployee/", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getDataEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
		try {
			return new ResponseEntity<String>(this.gson.toJson(this.employeeFacade.executeQuery(employeeRequestDTO)), HttpStatus.OK);
		}
        catch (BusinessException ex) {
            ex.printStackTrace();
            return new ResponseEntity<String> (this.gson.toJson(new Exception(ex)), HttpStatus.BAD_REQUEST);
        }
		catch (Exception e) {
		    e.printStackTrace();
			return new ResponseEntity<String> (this.gson.toJson(new Exception("Se presentaron problemas tecnicos intente nuevamente ")), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
