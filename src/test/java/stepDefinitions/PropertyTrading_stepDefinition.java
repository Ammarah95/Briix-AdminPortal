package stepDefinitions;
import org.openqa.selenium.By;

import WebPortal.Briix_Admin.OpenBrowser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.PropertyTrading_PageObject;

public class PropertyTrading_stepDefinition extends OpenBrowser {
	PropertyTrading_PageObject trading;
	
	@Given("User is on Property Trading page")
    public void user_is_on_property_trading_page() throws Throwable {
		
    	
		}

	@And("Click on {string}")
    public void Click_on(String details) throws Throwable {
    	
	}
	
	 @Then("Verify the status {string}")
	    public void verify_the_status(String verificationStatus) throws Throwable {
	 }
	 
	 @When("User change the assignee name {string}")
	    public void user_change_the_assignee_name(String assigneeName) throws Throwable {
	    	
	}
	 
	@When("User filtered out the status {string}")
	    public void user_filtered_out_the_status(String status) throws Throwable {
		trading.getfilterStatus().click();
    	Thread.sleep(5000);    	
    	driver.findElement(By.xpath("//label[contains(text(),'"+status+"')]")).click();
    	Thread.sleep(2000);
		}
	
	@Then("Verify the details of property")
    public void verify_the_details_of_the_property() throws Throwable {
 }

}
