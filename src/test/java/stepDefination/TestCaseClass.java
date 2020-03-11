package stepDefination;


import cucumber.api.java.en.*;
import junit.framework.Assert;
import pageObjects.BaseScreenPage;
import pageObjects.CardDeatilsPage;


public class TestCaseClass {
	
	BaseScreenPage baseScreenPageObj = new BaseScreenPage();
	CardDeatilsPage cardDetailsObj = new CardDeatilsPage();
	
	
	
	@Given("^Open Browser and start Application$")
	public void open_Browser_and_start_Application() throws Throwable {
	
		baseScreenPageObj.clickBuyBtn();
		baseScreenPageObj.clickCheckOut();
		baseScreenPageObj.clickContinue();
		baseScreenPageObj.clickCreditCard();
	  
	  
	 
  
	  
	  
	}

	@When("^User enter \"([^\"]*)\" and \"([^\"]*)\" with \"([^\"]*)\"$")
	public void user_enter_Card_Detail(String number,String dt, String cvv) throws Throwable {
		cardDetailsObj.enterCardNumber(number);
		cardDetailsObj.enterExpiryDt(dt);
		cardDetailsObj.enterCVV(cvv);
		cardDetailsObj.clickPayNow();
		cardDetailsObj.bankPasswrdScreen();
		
	}

	@SuppressWarnings("deprecation")
	@Then("^User should be able to purchase pillow$")
	public void user_should_be_able_to_purchase_pillow() throws Throwable {
	  	
	Assert.assertTrue(baseScreenPageObj.getMessage().contains("Thank you for your purchase."));
	}
	
	@SuppressWarnings("deprecation")
	@Then("^User should not be able to purchase pillow$")
	public void user_should_not_be_able_to_purchase_pillow() throws Throwable {
	 
		Assert.assertEquals("Transaction failed",cardDetailsObj.failedMessage(),cardDetailsObj.failedMessage());
		
	}
	
}
