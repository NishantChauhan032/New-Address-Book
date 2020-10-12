package com.capg.addressBook;

public class Contact {
	        public String firstName;
	        public String lastName;
	        public String address;
	        public String state;
	        public String city;
	        public String zip;
	        public String mobileNumber;
	        public String emailId;

	        public Contact(String firstName,String lastName,String address,String city,String state,String zip,String mobileNumber,String emailId)
	        {
	         this.firstName=firstName;
	         this.lastName=lastName;
	         this.address=address;
	         this.city=city;
	         this.state=state;
	         this.zip=zip;
	         this.mobileNumber=mobileNumber;
	         this.emailId=emailId;
	        }
		@Override
		public String toString()
	        {
	        return "First Name: "+firstName+" \nLast Name: "+lastName+"\nAddress :"+address+"\nCity: "+city+"\nZip: "+zip+"\nState: "+state+"\nMobile Number: "+mobileNumber+"\nEmail ID: "+emailId;
	        }
	}


