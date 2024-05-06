package application;

public class Traveler 
{
	private String firstName;
	private String middleName;
	private String lastName;
	private String dob;
	private String gender;
	private String email;
	private String phoneNumber;

	
	///////////////////////////// Getter Methods 
	public String getFirstName() 
	{
		return firstName;
	}
	
	public String getMiddleName() 
	{
		return middleName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public String getDob() 
	{
		return dob;
	}
	
	public String getGender() 
	{
		return gender;
	}
	
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	////////////////////////////// Setter Methods 
	
	
	public void setDob(String dob) 
	{
		this.dob = dob;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
		
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	
	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	 @Override
	    public String toString() {
	        return "Traveler{" +
	                "firstName='" + firstName + '\'' +
	                ", middleName='" + middleName + '\'' +
	                ", lastName='" + lastName + '\'' +
	                ", dob='" + dob + '\'' +
	                ", gender='" + gender + '\'' +
	                ", email='" + email + '\'' +
	                ", phoneNumber='" + phoneNumber + '\'' +
	                '}';
	    }
	
}