package application;

/**
*
* @author Jordan Kelley
* @author Esteban Naranjo
* 
* @version 2024.05.24.001
* 
* @see
* 	References:<br>
*         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
*         Retrieved from {@link https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving}
* 
*
* <br><br>
* Responsibilities of class:<br>
* 
*/

public class Payment 
{	
	private String cardNumber; 
	private String cardHolderName; 
	private String expiryDate; 
	private String cvv;
 
	
	public void setCardNumber(String cardNumber)
	{ 
		this.cardNumber = cardNumber; 
	}
	
	public void setCardHolderName(String cardHolderName)
	{ 
		this.cardHolderName = cardHolderName; 
	}
	
	public void setExpiryDate(String expiryDate)
	{ 
		this.expiryDate = expiryDate; 
	}
	
	public void setCVV(String cvv)
	{ 
		this.cvv = cvv; 
	}
	
	////////////////////////////////// Getter Methods 
	
	public String getCardNumber() 
	{ 
		return cardNumber; 
	}
	
	public String getcardHolderName()
	{ 
		return cardHolderName; 
	}
	
	public String getExpiryDate() 
	{ 
		return expiryDate; 
	}
	
	public String getCVV() 
	{ 
		return cvv; 
	}
	  @Override
	    public String toString() 
	    {
		    String redactedCardNumber = "************" + cardNumber.substring(12); 
	        return 
	                "Card Number: " + redactedCardNumber +
	                "\nExpiry Date: " + expiryDate + 
	                "\nCVV: " + cvv ;
	              
	                
	                
	                
	    }
	public void setCountry(String selectedCountry)
	{
		// TODO Auto-generated method stub
		
	}
	
	public void setState(String state)
	{
		// TODO Auto-generated method stub
		
	}
	public void setCity(String city)
	{
		// TODO Auto-generated method stub
		
	}
	public void setZipCode(String zipCode)
	{
		// TODO Auto-generated method stub
		
	}
	
}

