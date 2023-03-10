package com.example.Sql2DataStructure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.example.Sql2DataStructure.Service.FileReaderUtility;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Sql2DataStructureApplication {

	@Value("${spring.datasource.url}")
	private static String url;
	
	@Value("${spring.datasource.username}")
	private static String user;
	
	@Value("${spring.datasource.password}")
	private static String password;


	public static void main(String[] args) {
		try {
			FileReaderUtility file_1 = new FileReaderUtility();
			file_1.loadData(url,user,password);
		} catch (Exception ex) {
	        ex.printStackTrace();
		}
		SpringApplication.run(Sql2DataStructureApplication.class, args);
	}

}
