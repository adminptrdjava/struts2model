package com.model.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.bns.Userdtl;
import com.model.db.Dbmain;
import com.mysql.jdbc.Connection;

public class LoginService {

	  public boolean loginmethod(Userdtl ud){
		
		  Dbmain db = new Dbmain();
		  
		  try{
			  Connection con = db.dbconnect();
			  String Sql = "  SELECT * FROM admin where uid = ? and pass= ? ";
			  PreparedStatement ps = con.prepareStatement(Sql);
			  ps.setString(1, ud.getUid());
	          ps.setString(2, ud.getPass());
	          ResultSet rs= ps.executeQuery();
	          return rs.next();
			  
		  }catch(Exception E){
			  System.out.println("EXCEPTION "+ E);
			  return false;
		  }
		  
		 
		  
	  }
}
