package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import stepDefination.hooks;

public class BaseScreenPage {
	
	
	
	@FindBy(css =".btn.buy")
	private WebElement eleBuyBtn;
	
	@FindBy(css=".cart-checkout")
	WebElement eleCheckOut;
	
	@FindBy(css=".button-main-content")
	WebElement eleContinueBtn;
	
	@FindBy(xpath="//a[@href='#/credit-card']")
	WebElement eleCreditCard;
	
	@FindBy(css=".trans-status.trans-success")
	private WebElement eleConfirmationMsg;
	
	public void clickBuyBtn(){
		eleBuyBtn.click();
	}
	
	public void clickCheckOut(){
		hooks.getWait().until(ExpectedConditions.elementToBeClickable(eleCheckOut));
		eleCheckOut.click();
	}
	
	public void clickContinue(){

		
		hooks.getDriver().switchTo().frame("snap-midtrans");
		
		eleContinueBtn = hooks.getDriver().findElement(By.cssSelector(".button-main-content"));
		
		System.out.print(eleContinueBtn);
		hooks.getWait().until(ExpectedConditions.elementToBeClickable(eleContinueBtn));
		eleContinueBtn.click();

	}
	
	public void clickCreditCard(){
		
		eleCreditCard = hooks.getDriver().findElement(By.xpath("//a[@href='#/credit-card']"));
		
		hooks.getWait().until(ExpectedConditions.elementToBeClickable(eleCreditCard));	
		eleCreditCard.click();
	}
	
	public String getMessage(){
		hooks.getDriver().switchTo().defaultContent();
		
		hooks.getWait().until(ExpectedConditions.visibilityOf(eleConfirmationMsg));
		return eleConfirmationMsg.getText();
	}
	
	//Initialize Page Object
	public BaseScreenPage(){
		super();
		PageFactory.initElements(hooks.getDriver(), this);
	}
	
	
	
	
}
