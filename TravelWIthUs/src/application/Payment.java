package application;
/**
 * Lead Author(s):
 * 
 * @author Jordan Kelley
 * @author Esteban Naranjo
 *       
 * Other contributors:
 * 
 * References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 

 * Version/date: 2024.05.24.001
 * 
 * Responsibilities of class:
 *
 * 
 */

public class Payment 
{	
	private String cardNumber; 
	private String cardHolderName; 
	private String expiryDate; 
	private String cvv;
	private ApplicationModel model; 
	
	
	//////////////////////////////////// Setter Methods 
	public Payment (ApplicationModel model) 
	{ 
		this.model = model; 
	}
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

