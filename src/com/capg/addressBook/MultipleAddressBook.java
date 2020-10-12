package com.capg.addressBook;

import java.util.*;
import java.util.Map.Entry;

public class MultipleAddressBook {
	static Scanner sc=new Scanner(System.in);
	private static Map<String,AddressBookMain> addressMap=new TreeMap<>();
	public static void newAddressBook()
	{
		AddressBookMain object=new AddressBookMain();
		System.out.println("Enter the name of Address Book");
		String name=sc.next();
		addressMap.put(name,object);
		object.manageAddressBook();
	}
	
	public static void main(String args[])
	{
		char addNewAddressBook = 'Y';
		while(addNewAddressBook == 'Y') {
			
			MultipleAddressBook.newAddressBook();
			System.out.println("Want to add New Address Book?(Y/N) :");
			addNewAddressBook=sc.next().charAt(0);
			
		}
		
	}
}

