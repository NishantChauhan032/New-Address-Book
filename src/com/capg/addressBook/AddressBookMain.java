package com.capg.addressBook;

public class AddressBookMain
{
	private String firstName;
        private String lastName;
        private String address;
        private String state;
        private String city;
        private int zip;
        private long phoneNumber;
        private String emailId;

        public AddressBookMain(String firstName,String lastName,String address,String city,String state,int zip,long phoneNumber,String emailId)
        {
         this.firstName=firstName;
         this.lastName=lastName;
         this.address=address;
         this.city=city;
         this.state=state; 
         this.zip=zip;
         this.phoneNumber=phoneNumber;
         this.emailId=emailId;
        }
	@Override
	public String toString()
	{
	return "First Name: "+firstName+" \nLast Name: "+lastName+"\nAddress :"+address+"\nCity: "+city+"\nZip: "+zip+"\nState: "+state+"\nPhoneNumber: "+phoneNumber+"\nEmail ID: "+emailId;
	}
	public static void main(String args[])
	{
	
	}
}