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
	        
		public String getFirstName() {
				return firstName;
			}

			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}

			public String getLastName() {
				return lastName;
			}

			public void setLastName(String lastName) {
				this.lastName = lastName;
			}

			public String getAddress() {
				return address;
			}

			public void setAddress(String address) {
				this.address = address;
			}

			public String getState() {
				return state;
			}

			public void setState(String state) {
				this.state = state;
			}

			public String getCity() {
				return city;
			}

			public void setCity(String city) {
				this.city = city;
			}

			public String getZip() {
				return zip;
			}

			public void setZip(String zip) {
				this.zip = zip;
			}

			public String getMobileNumber() {
				return mobileNumber;
			}

			public void setMobileNumber(String mobileNumber) {
				this.mobileNumber = mobileNumber;
			}

			public String getEmailId() {
				return emailId;
			}

			public void setEmailId(String emailId) {
				this.emailId = emailId;
			}

		@Override
		public String toString()
	        {
	        return "First Name: "+firstName+" \nLast Name: "+lastName+"\nAddress :"+address+"\nCity: "+city+"\nZip: "+zip+"\nState: "+state+"\nMobile Number: "+mobileNumber+"\nEmail ID: "+emailId;
	        }
	}


