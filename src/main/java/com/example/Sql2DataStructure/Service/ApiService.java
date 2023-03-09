package com.example.Sql2DataStructure.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {
	
	@Autowired
	private FileReaderUtility file_read;
	
	public Map<String, Object> getServiceFunction() {
		Map<String, Object> response = new HashMap<>();
		response=file_read.getQueriedSqlData();
		return response;
	}
}
