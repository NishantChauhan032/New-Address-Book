package com.capg.addressBook;

import java.util.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
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
	public static void searchPersonInBook(String search)
	{
		int numberOfPerson=0;
		Iterator contactArray=addressMap.entrySet().iterator();
		while(contactArray.hasNext())
		{
			Map.Entry entry=(Map.Entry) contactArray.next();
			AddressBookMain a=(AddressBookMain)entry.getValue();
			List<Contact> list=a.getcontactArray();
			for(Contact con:list)
			{
				if(con.getCity().equals(search)||con.getState().equals(search))
				{
					System.out.println(con);
					numberOfPerson++;
				}
			}
			if(numberOfPerson==0)
				System.out.println("No person was found");
		}
	}
	public static void main(String args[])
	{
		MultipleAddressBook adBookManager=new MultipleAddressBook();
		while(true)
		{
			System.out.println("\n1. Add a new Address Book");
			System.out.println("\n2. Search person across all address books");
			System.out.println("\n3. Exit");
			System.out.println("\n Please Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
			while (true) {
				AddressBookMain main = new AddressBookMain();
				System.out.println("Enter a name for address Book");
				String name = sc.next();
				if (adBookManager.addressMap.containsKey(name)) {
					System.out.println("\nAddress Book already exists !!!\n");
					continue;
				}else {
					adBookManager.addressMap.put(name, main);
					System.out.println("\nNow you are In Address Book : " + name);
					main.manageAddressBook();
					break;
				}
			}
			break;

		case 2:
			System.out.println("Enter city or state to search a person");
			String searchIn = sc.next();
			adBookManager.searchPersonInBook(searchIn);
			break;

		case 3:
			break;
			}
		}
	}
}