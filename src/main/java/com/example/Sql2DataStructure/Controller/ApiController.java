package com.example.Sql2DataStructure.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Sql2DataStructure.Service.ApiService;

@RestController
public class ApiController {
	
	@Autowired
	private ApiService service;
	
	@CrossOrigin
	@PostMapping("/get_sql_ds_query")
	public Map<String,Object> getSQLDSQuery(){
		Map<String, Object> response = new HashMap<>();
		response= service.getServiceFunction();
		return response;
	}
}
