package com.capg.addressBook;

import java.util.*;

public class AddressBookMain
{
	static Scanner sc=new Scanner(System.in);	
	int numOfContact=0;
	private Contact[] contactArray;
	
	public AddressBookMain()
	{
		contactArray=new Contact[5];
	}
	private void addNewContact(String firstName,String lastName,String address,String city,String state,String zip,String mobileNumber,String emailId)
	{
		contactArray[numOfContact]=new Contact(firstName,lastName,address,city,state,zip,mobileNumber,emailId);
		System.out.println(contactArray[numOfContact]);
		numOfContact++;
	}
	public static void main(String args[])
	{

	System.out.print("Enter First Name,Last Name,Address,City,State,Zip,Mobile Number,Email (In order Mentioned): ");
	String fname=sc.next();
	String lname=sc.next();
	String newAddress=sc.next();
	String newCity=sc.next();
	String newState=sc.next();
	String zip=sc.next();
	String mobileNumber=sc.next();
	String email=sc.next();
	AddressBookMain Contact1=new AddressBookMain();
	Contact1.addNewContact(fname,lname,newAddress,newCity,newState,zip,mobileNumber,email);
	}
}