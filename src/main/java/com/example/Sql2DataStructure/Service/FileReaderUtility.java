package com.example.Sql2DataStructure.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileReaderUtility {
	public static List<String> sql_data_structure = new ArrayList<String>();

	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String user;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	public void loadData() {
		String query = "select Name,UseCaseKey from RankedPickList_Stories_Master;";
		
		
		try {
			System.out.println("url="+url);
			System.out.println("user="+user);
			System.out.println("password="+password);
			Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Create an ArrayList to hold the string values
            // ArrayList<String> list = new ArrayList<>();

            while (rs.next()) {
                String columnValue1 = rs.getString("column_name_1");
                String columnValue2 = rs.getString("column_name_2");
                String concatenatedValues = columnValue1 + " " + columnValue2;
                sql_data_structure.add(concatenatedValues);
            }

            // Print out the ArrayList
            System.out.println(sql_data_structure);

            // Close the database connection
            rs.close();
            stmt.close();
            conn.close();
		} catch (SQLException ex) {
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }
		}
	
	public Map<String,Object> getQueriedSqlData(){
		Map<String, Object> response = new HashMap<>();
		for(String line_l:sql_data_structure) {
			String value_1=line_l.substring(0,StringUtils.ordinalIndexOf(line_l, " ", 1));
	    	String value_2=line_l.substring(StringUtils.ordinalIndexOf(line_l, " ", 1)+1,StringUtils.ordinalIndexOf(line_l, " ", 2));
	    	response.put(value_1, value_2);
		}
		return response;
	}

}
