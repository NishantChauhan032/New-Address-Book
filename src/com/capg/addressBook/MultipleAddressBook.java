package com.capg.addressBook;

import java.util.*;

public class MultipleAddressBook {
	static Scanner sc = new Scanner(System.in);
	private static Map<String, AddressBookMain> addressMap = new TreeMap<>();
	public static Map<String, Contact> cityToContactEntryMap = new TreeMap<>();
	public static Map<String, Contact> stateToContactEntryMap = new TreeMap<>();

	public static void newAddressBook() {
		AddressBookMain object = new AddressBookMain();
		System.out.println("Enter the name of the Address Book : ");
		String name = sc.next();
		addressMap.put(name, object);
		object.manageAddressBook();
	}

	private static void showContactGroupedByCity() {
		Set<String> listOfCity = cityToContactEntryMap.keySet();
		for (String cityName : listOfCity) {
			System.out.println("Entry of Contact for CITY: " + cityName);
			searchPersonInBook(cityName);
		}
	}

	private static void showContactGroupedByState() {
		Set<String> listOfState = stateToContactEntryMap.keySet();
		for (String stateName : listOfState) {
			System.out.println("Entry of contact for STATE: " + stateName);
			searchPersonInBook(stateName);
		}
	}

	public static void countByCity() {
		Set<String> listOfCity = cityToContactEntryMap.keySet();
		for (String cityName : listOfCity) {
			Contact contactNumber = cityToContactEntryMap.get(cityName);
			System.out.println("Number of contact entries for CITY " + cityName + " "
					+ ((Map<String, AddressBookMain>) contactNumber).size());
		}
	}

	public static void countByState() {
		Set<String> listOfState = stateToContactEntryMap.keySet();
		for (String stateName : listOfState) {
			Contact contactNumber = stateToContactEntryMap.get(stateName);
			System.out.println("Number of contact entries for STATE " + stateName + " "
					+ ((Map<String, AddressBookMain>) contactNumber).size());
		}
	}

	public static void searchPersonInBook(String search) {
		int numberOfPerson = 0;
		Iterator contactArray = addressMap.entrySet().iterator();
		while (contactArray.hasNext()) {
			Map.Entry entry = (Map.Entry) contactArray.next();
			AddressBookMain a = (AddressBookMain) entry.getValue();
			List<Contact> list = a.getcontactArray();
			for (Contact cont : list) {
				if (cont.getCity().equals(search) || cont.getState().equals(search)) {
					System.out.println(cont);
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
			System.out.println("1. Add a new Address Book");
			System.out.println("2. Search person across all address books");
			System.out.println("3. Show contacts  by city");
			System.out.println("4. Show contacts by state");
			System.out.println("5. Count contacts  by city");
			System.out.println("6. Count contacts by state");
			System.out.println("7. Exit");
			System.out.println("Please Enter your choice from the above list : ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				while (true) {
					AddressBookMain main = new AddressBookMain();
					System.out.println("Enter a name for your address Book");
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
				countByCity();
				break;
			case 6:
				countByState();
				break;
			case 7:
				System.exit(0);
				break;
			}
		}
	}
}
