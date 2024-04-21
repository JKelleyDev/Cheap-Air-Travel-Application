package application;


public class Payment  
{	
	private String cardNumber; 
	private String cardHolderName; 
	private String expiryDate; 
	private String cvv;
	
	
	//////////////////////////////////// Setter Methods 
	
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
	
}
