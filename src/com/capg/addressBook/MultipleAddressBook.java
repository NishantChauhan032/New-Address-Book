package com.capg.addressBook;

import java.util.*;


public class MultipleAddressBook {
	static Scanner sc = new Scanner(System.in);
	private static Map<String, AddressBookMain> addressMap = new TreeMap<>();
	public static Map<String, Contact> cityToContactEntryMap = new TreeMap<>();
	public static Map<String, Contact> stateToContactEntryMap = new TreeMap<>();

	public static void newAddressBook() {
		AddressBookMain object = new AddressBookMain();
		System.out.println("Enter the name of Address Book");
		String name = sc.next();
		addressMap.put(name, object);
		object.manageAddressBook();
	}
    
	private static void showContactGroupedByCity() {
		Set<String> listOfCity = cityToContactEntryMap.keySet();
		for(String cityName : listOfCity) {
			System.out.println("Contact Entries for CITY: " + cityName);
			searchPersonInBook(cityName);
		}
	}

	private static void showContactGroupedByState() {
		Set<String> listOfState = stateToContactEntryMap.keySet();
		for(String stateName : listOfState) {
			System.out.println("Contact Entries for STATE: " + stateName);
			searchPersonInBook(stateName);
		}
	}
	public static void searchPersonInBook(String search) {
		int numberOfPerson = 0;
		Iterator contactArray = addressMap.entrySet().iterator();
		while (contactArray.hasNext()) {
			Map.Entry entry = (Map.Entry) contactArray.next();
			AddressBookMain a = (AddressBookMain) entry.getValue();
			List<Contact> list = a.getcontactArray();
			for (Contact con : list) {
				if (con.getCity().equals(search) || con.getState().equals(search)) {
					System.out.println(con);
					numberOfPerson++;
				}
			}
			if (numberOfPerson == 0)
				System.out.println("No person was found");
		}
	}
	public void showAddressBooks() {

		System.out.println("\nList of Address Books Added is shown : \n");
		addressMap.forEach((k, v) -> System.out.println(k + "\n"));
	}

	public static void main(String args[]) {
		MultipleAddressBook adBookManager = new MultipleAddressBook();
		while (true) {
			System.out.println("\n1. Add a new Address Book");
			System.out.println("\n2. Search person across all address books");
			System.out.println("\n3. Show contact  by city");
			System.out.println("\n4. Show contacts by state");
			System.out.println("\n5. Exit");
			System.out.println("\n Please Enter your choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				while (true) {
					AddressBookMain main = new AddressBookMain();
					System.out.println("Enter a name for address Book");
					String name = sc.next();
					if (adBookManager.addressMap.containsKey(name)) {
						System.out.println("\nAddress Book already exists !!!\n");
						continue;
					} else {
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
				showContactGroupedByCity();
				break;
			case 4:
				showContactGroupedByState();
				break;
			case 5:
				System.exit(0);
				break;
			}
		}
	}
}