package com.user;

import java.sql.SQLException;
import java.util.Scanner;

import com.model.Model;


public class TestApp {
public static void main(String[] args) throws Exception  {
	Scanner sc=new Scanner(System.in);
	Model m=new Model();
	while(true) {
	System.out.println("Enter Below the Choice:");
	System.out.println("1.Register Yourself\n2.SignUP\n3.LogOut ");
	int ch=sc.nextInt();
	
	switch(ch) {
	case 1:
    try {
        m.Register();
    }catch(SQLException e){
    	System.out.println("Registation Failed..");
    	//e.printStackTrace();
    }
		break;
		
	case 2:
		
		try {
		m.login();
	
		}catch(Exception e) {
			System.out.println("Something Went Wrong...!");
			e.printStackTrace();
		}
		
		break;
		
	case 3:
		System.out.println("Logout Sucessfully....");
		System.err.println("____________****Application Closed***_________________");
		System.exit(0);
		break;
		
		default:
			System.err.println("Wrong Choice code:");
		}
	}
	
}
}
