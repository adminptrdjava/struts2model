package com.model.db;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Dbmain {
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/demo";
	   String USER="root";
	   String PASS="";
	public  Connection dbconnect() {
	      Connection con=null;
	      try{
	    	  Class.forName(JDBC_DRIVER);
	    	  con =  (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
	    	  System.out.println(" con is"+con);
	    	  return con;
	    	  
	      }
	      catch (Exception E){
	    	  System.out.println("EXCEPTION "+ E);
	    	  con=null;
	    	  return con;
	      }
	}
}
