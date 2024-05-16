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
* This class stores information about a payment method 
* 
*/

public class Payment 
{	
	private String cardNumber; // A payment method has-a cardNumber
	private String cardHolderName; // A payment method has-a card holder name
	private String expiryDate; // A payment method has-a expiration date
	private String cvv; // A payment method has-a cvv 
 
	
	/**
     * sets the card number.
     * 
     * @param cardNumber The card number to set.
     */
	public void setCardNumber(String cardNumber)
	{ 
		this.cardNumber = cardNumber; 
	}
	
	/**
     * sets the card holder's name.
     * 
     * @param cardHolderName The card holder's name to set.
     */
	public void setCardHolderName(String cardHolderName)
	{ 
		this.cardHolderName = cardHolderName; 
	}
	
	/**
     * sets the expiry date of the card.
     * 
     * @param expiryDate The expiry date to set.
     */
	public void setExpiryDate(String expiryDate)
	{ 
		this.expiryDate = expiryDate; 
	}
	
	 /**
     * sets the CVV number.
     * 
     * @param cvv The CVV number to set.
     */
	public void setCVV(String cvv)
	{ 
		this.cvv = cvv; 
	}

	/**
     * returns the card number.
     * 
     * @return The card number.
     */
	public String getCardNumber() 
	{ 
		return cardNumber; 
	}
	 /**
     * returns the card holder's name.
     * 
     * @return The card holder's name.
     */
	public String getcardHolderName()
	{ 
		return cardHolderName; 
	}
	 /**
     * returns the expiry date of the card.
     * 
     * @return The expiry date.
     */
	public String getExpiryDate() 
	{ 
		return expiryDate; 
	}
	 /**
     * returns the CVV number.
     * 
     * @return The CVV number.
     */
	public String getCVV() 
	{ 
		return cvv; 
	}
	
	/**
     * overrides the toString method to return a string
     * representation of the Payment object.
     * 
     * @return A string representation of the Payment object.
     */
	  @Override
	    public String toString() 
	    {
		    String redactedCardNumber = "************" + cardNumber.substring(12); 
	        return 
	                "Card Number: " + redactedCardNumber +
	                "\nExpiry Date: " + expiryDate + 
	                "\nCVV: " + cvv ;
	              
	                
	                
	                
	    }
	  
	/**
	* sets the country for the payment.
	* 
	* @param selectedCountry The selected country.
	*/
	public void setCountry(String selectedCountry)
	{
		
		
	}
	
  /**
   * sets the state for the payment.
   * 
   * @param state The state to set.
   */
	public void setState(String state)
	{
		
		
	}
	
   /**
   * sets the city for the payment.
   * 
   * @param city The city to set.
   */
	public void setCity(String city)
	{
		
		
	}
	
  /**
   * sets the zip code for the payment.
   * 
   * @param zipCode The zip code to set.
   */
	public void setZipCode(String zipCode)
	{
		
		
	}
	
	
}

