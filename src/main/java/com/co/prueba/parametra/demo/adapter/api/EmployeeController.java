package com.co.prueba.parametra.demo.adapter.api;

import com.co.prueba.parametra.demo.adapter.ApiConst;
import com.co.prueba.parametra.demo.service.model.request.EmployeeRequestDTO;

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

    //Linea del contructor JSON
    @Autowired
    public EmployeeController( Gson gson) {
        this.gson = gson;
    }
    

    //Se crea el controlador que llama al servicio 
    @RequestMapping(value = "/network/", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getNetworkMultiLayer(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
		try {
			return new ResponseEntity<String>(this.gson.toJson(this.networkFacade.executeNetworkMultiLayer(employeeRequestDTO)), HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.error("Se presentaron problemas enviar la checkFields en el controller getBuses",e);
			return new ResponseEntity<String> (this.gson.toJson(ConstantErrors.ERRORS_STATES.get(UMBErrorEnum.GENERIC_ERROR.getCode())), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
