package com.model.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.bns.Userdtl;
import com.model.db.Dbmain;
import com.mysql.jdbc.Connection;

public  class UserdtlService {

	  static Userdtl utl = new Userdtl();
	 public  ArrayList getdtls(){
		 Userdtl p =  new Userdtl();
		 ArrayList a = new ArrayList();
		 
		 Dbmain db = new Dbmain();
		 try{
			 Connection con = db.dbconnect();
			 String SQL = "SELECT uid,pass FROM ADMIN";
			 PreparedStatement pr = con.prepareStatement(SQL);
			 ResultSet rs = pr.executeQuery();
			 
			 while(rs.next()){
				 Userdtl u = new Userdtl();
				u.setUid(rs.getString("uid"));
				u.setPass(rs.getString("pass"));
				a.add(u);
			 }
			
			 return a;
			
		 }catch(Exception E){
			 System.out.println("EXCEPTION E:"+E);
			 return null;
		 }
		
		 
	 }
	 
	 public boolean adduser(Userdtl ud){
		 Dbmain db = new Dbmain();
		 try{
			 System.out.println("ON MODEL");
			Connection con = db.dbconnect();
			String SQL = "INSERT INTO `admin`(`uid`, `pass`) VALUES (?,?) ";
			System.out.println("SQL DONE");
			PreparedStatement pr = con.prepareStatement(SQL);
			pr.setString(1, ud.getUid());
			pr.setString(2, ud.getPass());
			int i = pr.executeUpdate();
			if(i>=1){
				System.out.println("INSERT DONE");
				utl.setMsg("INSERT ONE");
				UserdtlService.msgset();
				return true;
			}
			else 
				return false;
		 }catch(Exception E){
			 System.out.println("SQL EXCEPTION:"+ E);
			 utl.setMsg(E.toString());
			 UserdtlService.msgset();
			 return false;
		 }
		 
	 }
	 
	 public static  Userdtl msgset(){
		 return utl;
	 }
}
