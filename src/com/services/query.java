package com.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.model.ConnectionTable1;



public class query {
	Scanner sc=new Scanner(System.in);
public void delete() throws Exception {
	String deleteData="delete from register2 where id=?";
	PreparedStatement psd=ConnectionTable1.con().prepareStatement(deleteData);
	System.out.println("Enter id of Register Which you want to Delete");
	int id=sc.nextInt();
	String retriveData="select id from register2";
	PreparedStatement psd1=ConnectionTable1.con().prepareStatement(retriveData);
	ResultSet rs=psd1.executeQuery();
	boolean temp=false;
	while(rs.next()) {
		if(rs.getInt(1)==id) {
			temp=true;
			break;
		}
	}
	if(temp==true) {
		psd.setInt(1,id);
		psd.execute();
		
		psd.close();
		ConnectionTable1.con().close();
		System.out.println("Delete Registerd id ScuessFully");	
	}else {
		System.err.println("Id is not Valid!!!!....");
	}
	
}
public void update() throws Exception {

	String updateData="update register2 set password=? where id=?";
	PreparedStatement psu=ConnectionTable1.con().prepareStatement(updateData);
	System.out.println("Enter id of Register Which you want to update");
	int id=sc.nextInt();
	String retriveData="select id from register2";
	PreparedStatement psu1=ConnectionTable1.con().prepareStatement(retriveData);
	ResultSet rs=psu1.executeQuery();
	boolean temp=false;
	while(rs.next()) {
		if(rs.getInt(1)==id) {
			temp=true;
			break;
		}
	}
	if(temp==true) {
		psu.setInt(2,id);
		//System.out.println("Enter id Register :");
		//psu.setString(2,sc.next());
		System.out.println("Enter Update password");
		psu.setString(1,sc.next());
		psu.execute();
		
		psu.close();
		ConnectionTable1.con().close();
		System.out.println("update Register PassWord ScuessFully");	
	}else {
		System.err.println("Id is not Valid!!!!....");
	}
	
}
public void veiwRegisterList() throws Exception {
	String retriveData="select * from register2";
	PreparedStatement psr=ConnectionTable1.con().prepareStatement(retriveData);
	ResultSet rs=psr.executeQuery();
	while(rs.next()) {
		System.out.println("Id:"+rs.getInt(1)+"  Reg Name: "+rs.getString(2)+" \t Reg mobNo: "+rs.getString(3)+"\tReg Email: "+rs.getString(4)+"\t Reg Password: "+rs.getString(5));
		System.out.println("_________________________________________________________________________________________________");
	}
	psr.close();
	ConnectionTable1.con().close();
	
}
}
