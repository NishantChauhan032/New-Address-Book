package com.capg.addressBook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
public class AddressBookMain 
{
	static Scanner sc=new Scanner(System.in);
	static ArrayList<Contact> myContactArrayList;
	
	public Map<String,Contact> nameToContactMap;
	public Map<String, List<Contact>> stateToContactMap;
	public Map<String, List<Contact>> cityToContactMap;
	
	public AddressBookMain()
	{
		myContactArrayList=new ArrayList<>();
		nameToContactMap = new LinkedHashMap<String, Contact>();
	}
	public List<Contact> getcontactArray() {
		return myContactArrayList;
	}
	public Map<String,Contact> getcontactMap()
	{
		return nameToContactMap;
	}
	public void addNewContact()
	{
		String firstName="";
		String lastName="";
		while(true)
		{
		System.out.println("Enter First Name");
		firstName=sc.next();
		System.out.println("Enter last Name");
		lastName=sc.next();
		if (checkForDuplicate(firstName, lastName))
			continue;
		else
			break;
		}
		System.out.println("Enter Address");
		String address=sc.next();
		System.out.println("Enter City");
		String city=sc.next();
		System.out.println("Enter State");
		String state=sc.next();
		System.out.println("Enter Pincode");
		int pinCode=sc.nextInt();
		System.out.println("Enter phone Number");
		long phoneNumber=sc.nextLong();
		System.out.println("Enter Email ID");
		String emailId=sc.next();
		Contact addNewContact = new Contact(firstName,lastName,address,city,state,pinCode,phoneNumber,emailId);
		myContactArrayList.add(addNewContact);
		
		String name=firstName+" "+lastName;
		nameToContactMap.put(name,addNewContact);
	}
	public void printContacts()
	{
		System.out.println(myContactArrayList);
	}
	public void editContact()
	{
		System.out.println("Enter First Name of contact to edit the contact details");
		String firstName=sc.next();
		System.out.println("Enter last Name of contact to edit the contact details");
		String lastName=sc.next();
		String name=firstName+" "+lastName;
		Contact editedContactObject = nameToContactMap.get(name);
				System.out.print("Enter Address,City,State,Pincode,Phone Number & Email ID ");
				String editedAddress=sc.next();
				editedContactObject.setAddress(editedAddress);
				String editedCity=sc.next();
				editedContactObject.setCity(editedCity);
				String editedState=sc.next();
				editedContactObject.setState(editedState);
				int editedPin=sc.nextInt();
				editedContactObject.setPinCode(editedPin);
				long editedNumber=sc.nextLong();
				editedContactObject.setPhoneNumber(editedNumber);
				String editedEmail=sc.next();
				editedContactObject.setEmailId(editedEmail);
	}
	public void deleteContactDetails() 
	{
		System.out.println("Enter The First Name to delete the contact details");
		String firstName=sc.next();
		System.out.println("Enter The last Name to delete the contact details");
		String lastName=sc.next();
			String name=firstName+" "+lastName;
			Contact object=nameToContactMap.get(name);
			myContactArrayList.remove(object);
			nameToContactMap.remove(name);
			System.out.println("Contact deleted");
		
	}
	/*UC7*/
	public boolean checkForDuplicate(String firstname, String lastname) 
	{
		if (myContactArrayList.stream().anyMatch(obj -> obj.getFirstName().equals(firstname))
				&& myContactArrayList.stream().anyMatch(obj -> obj.getLastName().equals(lastname))) 
		{
			System.out.println("This contact already exists, try again!!");
			return true;
		} 
		else
			return false;
	}
	/*UC11*/
	public void sortByName()
	{
	List<Contact> sortByNameList = myContactArrayList.stream()
	.sorted(Comparator.comparing(Contact::getFirstName))
	.collect(Collectors.toList());
	sortByNameList.forEach(System.out::println);
	}
	/*UC12*/
	public void sortByCity()
	{
	List<Contact> sortByCityList = myContactArrayList.stream()
	.sorted(Comparator.comparing(Contact::getCity))
	.collect(Collectors.toList());
	sortByCityList.forEach(System.out::println);
	}
	public void sortByState()
	{
	List<Contact> sortByStateList = myContactArrayList.stream()
	.sorted(Comparator.comparing(Contact::getState))
	.collect(Collectors.toList());
	sortByStateList.forEach(System.out::println);
	}
	public void sortByZip()
	{
	List<Contact> sortByZipList = myContactArrayList.stream()
	.sorted(Comparator.comparingInt(Contact::getPinCode))
	.collect(Collectors.toList());
	}
	public void maintainAddressBook()
	{	
		boolean check=true;
		while (check==true) 
		{
			System.out.println("1. Add Contact Details");
			System.out.println("2. Edit Contact Details");
			System.out.println("3. Delete Contact Details");
			System.out.println("4. Show Contact details");
			System.out.println("5. Sort details by name");
			System.out.println("6. Sort details by State");
			System.out.println("7. Sort details by PinCode");
			System.out.println("8. Exit");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:addNewContact();
			break;
			case 2:if(myContactArrayList.size()==0)
					System.out.println("Plese Enter contacts");
					else
				    editContact();
			break;
			case 3:if(myContactArrayList.size()==0)
					System.out.println("Plese Enter contacts");
					else
						deleteContactDetails();
			break;
			case 4:printContacts();
			break;
			case 5:sortByName();
			break;
			case 6:sortByState();
			break;
			case 7:sortByZip();
			break;
			case 8:System.out.println("Exit");
				   check=false;
			break;
			}
		}
	}
}