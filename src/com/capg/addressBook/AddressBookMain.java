package com.capg.addressBook;

import java.util.*;

public class AddressBookMain
{
	static Scanner sc=new Scanner(System.in);	
	int numOfContact=0;
	private ArrayList<Contact> contactArray;
	private Map<String,Contact> contactMap;
	public AddressBookMain()
	{
		contactArray=new ArrayList<>();
		contactMap=new HashMap<>();
	}
	public void addNewContact(String firstName,String lastName,String address,String city,String state,String zip,String mobileNumber,String emailId)
	{
		Contact newContact = new Contact(firstName,lastName,address,city,state,zip,mobileNumber,emailId);
		contactArray.add(newContact);
		contactMap.put(firstName,newContact);
	}
	public void printContact()
	{
	System.out.println(contactArray);
	}
	public void editContact()
	{
		System.out.println("Enter The First Name to edit the contact details");
		String fName1=sc.next();
		Contact obj=contactMap.get(fName1);
		System.out.println("Enter the Address");
		String address1=sc.next();
		obj.setAddress(address1);
		System.out.println("Enter the City");
		String city1=sc.next();
		obj.setCity(city1);
		System.out.println("Enter the State");
		String state1=sc.next();
		obj.setState(state1);
		System.out.println("Enter the Zip");
		String zip=sc.next();
		obj.setZip(zip);
		System.out.println("Enter the Number");
		String number1=sc.next();
		obj.setMobileNumber(number1);
		System.out.println("Enter the Email");
		String email1=sc.next();
		obj.setEmailId(email1);
	}
	public static void main(String args[])
	{
	System.out.println("Enter FirstName,Last Name,Address,City,State,Zip,Mobile Number,Email ID (In mentioned order) :");
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
	Contact1.printContact();
	Contact1.editContact();
	System.out.println("Contact Details After Editing : ");
	Contact1.printContact();
	}
}
