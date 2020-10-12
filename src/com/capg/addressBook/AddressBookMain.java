package com.capg.addressBook;

import java.util.*;

public class AddressBookMain {
	static Scanner sc = new Scanner(System.in);
	private ArrayList<Contact> contactArray;
	private Map<String, Contact> contactMap;

	public AddressBookMain() {
		contactArray = new ArrayList<>();
		contactMap = new HashMap<>();
	}

	public void addNewContact() {
		System.out.println("Enter First Name : ");
		String firstName = sc.next();
		System.out.println("Enter last Name : ");
		String lastName = sc.next();
		System.out.println("Enter the Address : ");
		String address = sc.next();
		System.out.println("Enter the City : ");
		String city = sc.next();
		System.out.println("Enter the State : ");
		String state = sc.next();
		System.out.println("Enter the Zip : ");
		String zip = sc.next();
		System.out.println("Enter the Mobile Number : ");
		String mobileNumber = sc.next();
		System.out.println("Enter the Email");
		String emailId = sc.next();
		Contact newContact = new Contact(firstName, lastName, address, city, state, zip, mobileNumber, emailId);
		contactArray.add(newContact);
		contactMap.put(firstName, newContact);
	}

	public void printContact() {
		System.out.println(contactArray);
	}

	public void editContact() {
		System.out.println("Enter The First Name to edit the contact details");
		String fName1 = sc.next();
		Contact obj = contactMap.get(fName1);
		System.out.println("Enter the Address");
		String address1 = sc.next();
		obj.setAddress(address1);
		System.out.println("Enter the City");
		String city1 = sc.next();
		obj.setCity(city1);
		System.out.println("Enter the State");
		String state1 = sc.next();
		obj.setState(state1);
		System.out.println("Enter the Zip");
		String zip = sc.next();
		obj.setZip(zip);
		System.out.println("Enter the Number");
		String number1 = sc.next();
		obj.setMobileNumber(number1);
		System.out.println("Enter the Email");
		String email1 = sc.next();
		obj.setEmailId(email1);
	}

	public void deleteContact() {
		System.out.println("Enter The First Name to delete the contact details");
		String firstNameToBeDeleted = sc.nextLine();
		Contact obj = contactMap.get(firstNameToBeDeleted);
		contactArray.remove(obj);
	}

	public static void main(String args[]) {
		AddressBookMain contact = new AddressBookMain();
		while (true) {
			System.out.println("Do You Want to Add New Contact(Y/N) : ");
			char choice = sc.next().charAt(0);
			if (choice == 'Y') {
				contact.addNewContact();
				contact.printContact();
			} else
				break;
		}
	}
}
