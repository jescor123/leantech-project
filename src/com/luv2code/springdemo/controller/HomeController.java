package com.luv2code.springdemo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/demo")
public class HomeController {

	@GetMapping("/startH2")
	public void startAppH2Bd() {
				
		System.out.println("initializing system ...");
		System.out.println("loading H2 database ...");

		String user = "sa";
		String pass = "";

		String jdbcUrl = "jdbc:h2:tcp://localhost/~/test";
		String driver = "org.h2.Driver";

		// get connection to database
		try {
			
			System.out.println("Connecting to database: " + jdbcUrl);

			Class.forName(driver);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			Statement stmt = myConn.createStatement();
			
			
			
			String sqlTable1 = "DROP TABLE POSITION IF EXISTS; CREATE TABLE POSITION " +
	                   "(id NUMBER not NULL, " +
	                   " name VARCHAR(255), " +
	                   " PRIMARY KEY ( id ))"; 
	        stmt.executeUpdate(sqlTable1);
	        
	        String sqlTable2 = "DROP TABLE PERSON IF EXISTS; CREATE TABLE PERSON " +
	                   "(id NUMBER not NULL, " +
	                   " name VARCHAR(255), " +
	                   " lastname VARCHAR(255), " +
	                   " address VARCHAR(255), " +
	                   " cellphone NUMBER, " +
	                   " cityname VARCHAR(255), " +
	                   " PRIMARY KEY ( id ))"; 
	        stmt.executeUpdate(sqlTable2);
	        
	        String sqlTable3 = "DROP TABLE EMPLOYEE IF EXISTS; CREATE TABLE EMPLOYEE " +
	                   "(id NUMBER not NULL AUTO_INCREMENT, " +
	                   " person NUMBER, " +
	                   " position NUMBER, " +
	                   " salary NUMBER, " +
	                   " name VARCHAR(255), " +
	                   " positiondesc VARCHAR(255), " +
	                   " PRIMARY KEY ( id ))";
	        stmt.executeUpdate(sqlTable3);
	        
	        String sqlInserts = "INSERT INTO POSITION (id, name) VALUES (1, 'Dev');"
	        		+ " INSERT INTO POSITION (id, name) VALUES (2, 'QA');"
	        		+ " INSERT INTO EMPLOYEE (ID, PERSON, POSITION, SALARY, NAME, POSITIONDESC) VALUES (1,3,1,5050000,'Josnuel','Dev');"
	        		+ " INSERT INTO EMPLOYEE (ID, PERSON, POSITION, SALARY, NAME, POSITIONDESC) VALUES (2,2,2,10000,'Hiptis','QA');"
	        		+ " INSERT INTO EMPLOYEE (ID, PERSON, POSITION, SALARY, NAME, POSITIONDESC) VALUES (3,1,1,2300,'Jescor','Dev');"
	        		+ " INSERT INTO PERSON (ID, NAME, LASTNAME, ADDRESS, CELLPHONE, CITYNAME) VALUES (1, 'Jescor', 'Alvarado', 'Zentrum Strasse nummer vier', 584120208202, 'Berlin');"
	        		+ " INSERT INTO PERSON (ID, NAME, LASTNAME, ADDRESS, CELLPHONE, CITYNAME) VALUES (2, 'Hiptis', 'Urribarri', 'Zentrum Strasse nummer vier', 584122098716, 'Berlin');"
	        		+ " INSERT INTO PERSON (ID, NAME, LASTNAME, ADDRESS, CELLPHONE, CITYNAME) VALUES (3, 'Josnuel', 'Alvarado', 'Zentrum Strasse nummer vier', 196202000397, 'Berlin');"
	        		+ " INSERT INTO PERSON (ID, NAME, LASTNAME, ADDRESS, CELLPHONE, CITYNAME) VALUES (4, 'Andres', 'Alvarado', 'Oviedo pueblo natural', 2010088522000, 'Oviedo');"; 

	        stmt.executeUpdate(sqlInserts);
	        
			
			System.out.println("DATA PROCESSED SUCCESSFULLY!!!");
			
			myConn.close();

		}
		catch (Exception exc) {
			exc.getMessage();
			
		}
		
	}
	
}
