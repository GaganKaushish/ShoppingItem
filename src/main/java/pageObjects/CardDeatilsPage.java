package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import resources.hooks;

public class CardDeatilsPage {

	

	@FindBy(name ="cardnumber")
	private WebElement eleCardNumbr;
	
	@FindBy(css=".input-group.col-xs-7>input")
	private WebElement eleExpirayDate;
	
	@FindBy(css=".input-group.col-xs-5>input")
	private WebElement eleCVV;
	
	@FindBy(className="button-main-content")
	private WebElement elePayNow;
	
	@FindBy(id="PaRes")
	private WebElement elePasswrd;
	
	@FindBy(css="button[type='submit']")
	private WebElement eleOkBtn;
	
	
	
	public void enterCardNumber(String num){
		hooks.getWait().until(ExpectedConditions.visibilityOf(eleCardNumbr));
		hooks.getWait().until(ExpectedConditions.elementToBeClickable(eleCardNumbr));
		eleCardNumbr.click();
		eleCardNumbr.clear();
		eleCardNumbr.sendKeys(num);
	}
	
	public void enterExpiryDt(String dt){
		eleExpirayDate.sendKeys(dt);
	}
	
	public void enterCVV(String cvv){
		eleCVV.sendKeys(cvv);
	}
	
	public void clickPayNow(){
		hooks.getWait().until(ExpectedConditions.elementToBeClickable(elePayNow));
		elePayNow.click();
	}
	
	public void bankPasswrdScreen(){
		
		hooks.getDriver().switchTo().frame(0);
		elePasswrd = hooks.getDriver().findElement(By.id("PaRes"));
		hooks.getWait().until(ExpectedConditions.elementToBeClickable(elePasswrd));
		elePasswrd.click();
		elePasswrd.sendKeys("112233");
		eleOkBtn.click();
	}
	
	//Initialize Page Object
		public CardDeatilsPage(){
			super();
			PageFactory.initElements(hooks.getDriver(), this);
		}
}
