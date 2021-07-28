package com.test.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class TestController {

	@Autowired 
	DataSource dataSource;
	
	Connection conn = null;
	//@ResponseBody
	//@RequestMapping("/hello")
	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	public String hello(Model model) {
		
		try {
			conn = dataSource.getConnection();
			System.out.println("Connection Obj::::"+conn);
			
			String query = "CREATE TABLE TABLE1"
					+ "(COLUMN1 VARCHAR2(20))";
			
			System.out.println(query);
			Statement st = conn.createStatement();
			//st.execute(query);
			st.close();
			conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "welcome";
	}
}
