package com.capg.addressBook;

import java.util.*;
import java.util.function.Predicate;

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
		if(checkDuplicateName(newContact)) {
			System.out.println("Contact Already Exists!");
		}else {
		contactArray.add(newContact);
		contactMap.put(firstName, newContact);
	  } 
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
	public void manageAddressBook()
	{
		boolean check=true;
		while (check) 
		{
			System.out.println("\n1. Add Contact Details");
			System.out.println("\n2. Edit Contact Details");
			System.out.println("\n3. Delete Contact Details");
			System.out.println("\n4. Exit");
			System.out.println("\nEnter your choice from the above list : ");
			int selection=sc.nextInt();
			switch(selection)
			{
			case 1:addNewContact();
			break;
			case 2:if(contactArray.size()==0)
					System.out.println("Sorry,No contact in the list. Please add some contacts to perform this task!");
					else
				    editContact();
			break;
			case 3:if(contactArray.size()==0)
					System.out.println("Sorry,No contact in the list. Please add some contacts to perform this task!");
					else
						deleteContact();
			break;
			case 4:System.out.println("Exit");
				   check = false;
			break;
			default :
				System.out.println("Select correct input!");
			}
	     }
	}
	public boolean checkDuplicateName(Contact contact)
	 {
	Predicate<Contact> verifyDuplicateName = (c)-> c.equals(contact);
		boolean checkDuplicacy = contactArray.stream().anyMatch(verifyDuplicateName);
		return checkDuplicacy;	
	}
}
