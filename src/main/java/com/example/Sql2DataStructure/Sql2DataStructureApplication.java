package com.example.Sql2DataStructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.example.Sql2DataStructure.Service.FileReaderUtility;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Sql2DataStructureApplication {

	public static void main(String[] args) {
		try {
			FileReaderUtility file_1 = new FileReaderUtility();
			file_1.loadData();
		} catch (Exception ex) {
	        ex.printStackTrace();
		}
		SpringApplication.run(Sql2DataStructureApplication.class, args);
	}

}
