package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import WebPortal.Briix_Admin.OpenBrowser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Investment_PageObject;


public class Investment_stepDefinition extends OpenBrowser {
	Investment_PageObject Invest;
	WebElement selectFilter, acceptButton, Message;
	Select select;
	
	String CustomerName;
	
	@Given("User is on Investment page")
    public void user_is_on_investment_page() throws Throwable {
		Invest=new Investment_PageObject(driver);
		Invest.getinvestment().click();
		}

	@When("User filtered out {string} status")
    public void user_filtered_out_pending_status(String status) throws Throwable {
    	Invest.getfilter().click();
    	Thread.sleep(5000);    	
    	selectFilter=driver.findElement(By.xpath("//button[1]//div[1]//input[1]"));
    	selectFilter.click();


	}
	 @Then("Verify the status of investment should be changed")
	    public void verify_the_status_of_investment_should_be_changed() throws Throwable {
		 selectFilter=Invest.getaccept();
	    	boolean isSelected = selectFilter.isSelected();
	    	if(isSelected == false) {
	    		selectFilter.click();
	    		search_the_customer_name(CustomerName);
	    		String status=Invest.getstatusProcessed().getText();
	    		if(status.equalsIgnoreCase("Processed")) {
	    			System.out.println("Status changed to "+status);
	    		}else {
	    			System.out.println("Incorrect status updated ");
	    		}
	    		
	    		
	 }
	 }

	@And("Search the customer name {string}")
    public void search_the_customer_name(String name) throws Throwable {
		
    	Invest.getserachText().sendKeys(name);
    	CustomerName=name;
    	
	}
	
	@And("User accept the investement")
    public void user_accept_the_investment() throws Throwable {
		acceptButton=Invest.getacceptButton();
		if(acceptButton.isEnabled()) {
		Invest.getacceptButton().click();
		Thread.sleep(2000);
		}
		Message=Invest.getconfirmationMessage();
		if(Message.isDisplayed()) {
			Invest.getaccept().click();	
		}
		
	
    	
	}
}
