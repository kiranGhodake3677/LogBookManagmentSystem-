package com.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import com.services.query;



public class Model {
	Scanner sc=new Scanner(System.in);
	query q=new query();
public void Register() throws Exception{
	
	String insertData="insert into register2 values(?,?,?,?,?)";
	PreparedStatement psi=ConnectionTable1.con().prepareStatement(insertData);
	
		System.out.println("Enter User id ");
		psi.setInt(1, sc.nextInt());
	
	System.out.println("Enter User name :");
	String name=sc.next()+sc.nextLine();
	psi.setString(2, name);

	System.out.println("Enter User  mobno:");
	psi.setString(3,sc.next() + sc.nextLine());
	
	String email=name+"@logbook";
	psi.setString(4, email);
	System.out.println("emial Id : "+email);
	String pass=generatepassword();
	psi.setString(5, pass);
	System.out.println("PassWord : "+pass);
	psi.execute();
	ConnectionTable1.con().close();
	
	psi.close();
	
}
public static String generatepassword() {
	
	final String lowerCase="abcdefghijklmnopqrstuvwxyz";
	final String upperCase=lowerCase.toUpperCase();
	final String number="0123456789";
	final String otherChar="!@#$%&*";
	final String combine=lowerCase+upperCase+number+otherChar;
	
	Random random=new Random();
	StringBuilder pass=new StringBuilder();
	
	for(int i=0;i<=4;i++) {
		int randomIndex=random.nextInt(combine.length());
		pass.append(combine.charAt(randomIndex));
	}
	
	return pass.toString();
}

   

public void userlogin() throws Exception 
  {
	System.out.println("Enter emial Address:");
	String email=sc.next()+sc.nextLine();
	
    System.out.println("Enter User pass:");
    String pass=sc.next();
    String retriveUser="select * from register2";
	try {
	PreparedStatement ps1=ConnectionTable1.con().prepareStatement(retriveUser);
	
	
	ResultSet rs=ps1.executeQuery();
	
	boolean temp=false;
	
	while(rs.next())
	{
			if(rs.getString(5).equals(pass) && rs.getString(4).equals(email)) {
				temp=true;
				break;
			}
	}   
	
	if(temp==true) {
		System.err.println("Login Succssfully.....");
	}
	else {
		System.err.println("Invalid ID & PassWord");
	}
	
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	
}
public void adminLogin() throws Exception {
	System.out.println("Enter Email address: ");
	String email=sc.next();
	System.out.println("Enter your PassWord: ");
	String password=sc.next();
	
	String retriveData="select * from admin";
	
	PreparedStatement sp=ConnectionTable1.con().prepareStatement(retriveData);
	ResultSet sr=sp.executeQuery();
	
boolean temp=false;
	
	while(sr.next())
	{
			if(sr.getString(4).equals(password) && sr.getString(3).equals(email)) {
				temp=true;
				break;
			}
	}   
	
	if(temp==true) {
		System.err.println("Login Succssfully.....");
		boolean chh=true;
		while(chh) {
		System.out.println("1.Delete RegID\n2.Update PassWord RegId\n3.Veiw Reg List\n4.LogOut");
		System.out.println("Enter the choice code:");
		int ch=sc.nextInt();
		switch(ch) {
		case 1:
			 q.delete();
		     break;
		     
		case 2:
			q.update();
			break;
		case 3:
			q.veiwRegisterList();
			break;
		case 4:
			System.out.println("Admin Logout Successfully..");
			chh=false;
			break;
		default :
			System.out.println("Wrong Choice code:");
				
		
		}
	}
	}
	else {
		System.err.println("Invalid ID & PassWord");
	}
}

public void login() throws Exception {
	
	boolean chh=true;
	while(chh) {
	System.out.println("1.User Login\n2.Admin Login\n3.Exit");
	System.out.println("Enter the choice code:");
	int ch=sc.nextInt();
	
	switch(ch) {
	
	case 1:
		userlogin();
		break;
	case 2:
		
		adminLogin();
		break;
		
		
	case 3:
		System.out.println("__________***Login Closed***______________");
		chh=false;
		break;
	default :
		System.out.println("Wrong Choice code:");
			
	
	}
}
}
}

