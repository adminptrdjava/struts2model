package com.model.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.bns.ZoneBean;
import com.model.db.Dbmain;
import com.mysql.jdbc.Connection;


public class ZoneManage {

	
	public ArrayList zoneview(){
		Dbmain db = new Dbmain();
		ArrayList a = new ArrayList();
		try{
			Connection con = db.dbconnect();
			String SQL = "SELECT * FROM zone";
			PreparedStatement pr = con.prepareStatement(SQL);
			ResultSet rs = pr.executeQuery();
			while(rs.next()){
				ZoneBean zvo = new ZoneBean();
				zvo.setZid(rs.getString(1));
				zvo.setZname(rs.getString(3));
				zvo.setZpin(rs.getString(2));
				zvo.setZadd(rs.getString(4));
				zvo.setZtype(rs.getString(5));
				a.add(zvo);
			}
			return a;
		}catch(SQLException E){
			System.out.println("ERROR "+E);
			return null;
		}
		
		
		
	}
	
	public boolean zoneaddMethod(ZoneBean zb){
		Dbmain db = new Dbmain();
		
		try{
			Connection con = db.dbconnect();
			String SQL = "INSERT INTO `zone`( `PINCODE`, `ZNAME`, `ZADDRESS`, `ZTYPE`) VALUES (?,?,?,?)";
			PreparedStatement pr = con.prepareStatement(SQL);
			
			pr.setString(1, zb.getZpin());
			pr.setString(2, zb.getZname());
			pr.setString(3, zb.getZadd());
			pr.setString(4, zb.getZtype());
			int i = pr.executeUpdate();
			if(i>=0){
				return true;
			}
			else 
				return false;
		}catch(Exception E){
			System.out.println(""+E);
			return false;
		}
		
	}
}
