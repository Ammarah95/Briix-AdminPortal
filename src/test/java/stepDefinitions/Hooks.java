package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import WebPortal.Briix_Admin.OpenBrowser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
public class Hooks extends OpenBrowser {
	
	
	@Before
	public void beforevalidation() {
		
	}
	
	@After(order=1)
	public void takeScreenshotOnFailure(Scenario scenario) throws Exception{
		if(scenario.isFailed()) {
		TakesScreenshot ts = (TakesScreenshot) Hooks.driver;
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "");
		}
		else {
			System.out.println("Test scenario is successfully completed");
		}
	}
	
	
	  @After(order=0) 
	  public void aftervalidation() throws Exception {
	  driver.manage().deleteAllCookies();
	  driver.quit();
	 
	  }
	 
}
