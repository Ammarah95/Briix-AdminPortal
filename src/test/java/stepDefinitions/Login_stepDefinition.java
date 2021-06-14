package stepDefinitions;

import java.time.Duration;
import java.util.Scanner;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

import WebPortal.Briix_Admin.OpenBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObject.Login_PageObject;

@RunWith(Cucumber.class)

public class Login_stepDefinition extends OpenBrowser {
	Login_PageObject Login;
	String URL;
	
	@Given("User is on login page")
    public void user_is_on_login_page() throws Throwable {
		driver=OpenBrowser.getDriver();
		Login=new Login_PageObject(driver);
		}

    @When("^User provide a valid credentials (.+) (.+)$")
    public void user_provide_a_valid_credentials(String userName, String password) throws Throwable {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30, 0));
    	Login.getuserName().sendKeys(userName);
    	Login.getpassword().sendKeys(password);
    	URL=driver.getCurrentUrl();
    	Login.getloginButton().click();       
    }

    @When("User provide the OTP")
    public void user_provide_the_otp() throws Throwable {
    	Scanner sc =new Scanner(System.in);
    	System.out.println("Enter the OTP: ");
    	String OTP=sc.nextLine();
    	System.out.println(" The received otp is "+OTP);
		String[] splits = OTP.split("");
		String otp1=splits[0];
		String otp2=splits[1];
		String otp3=splits[2];
		String otp4=splits[3];
		String otp5=splits[4];
		String otp6=splits[5];
		
		WebElement Otpdigit1=Login.getOTPvalue1();
		Otpdigit1.clear();
		Otpdigit1.sendKeys(otp1);
		WebElement Otpdigit2=Login.getOTPvalue2();
		Otpdigit2.clear();
		Otpdigit2.sendKeys(otp2);
		WebElement Otpdigit3=Login.getOTPvalue3();
		Otpdigit3.clear();
		Otpdigit3.sendKeys(otp3);
		WebElement Otpdigit4=Login.getOTPvalue4();
		Otpdigit4.clear();
		Otpdigit4.sendKeys(otp4);
		WebElement Otpdigit5=Login.getOTPvalue5();
		Otpdigit5.clear();
		Otpdigit5.sendKeys(otp5);
		WebElement Otpdigit6=Login.getOTPvalue6();
		Otpdigit6.clear();
		Otpdigit6.sendKeys(otp6);
		
    	
        
    }

    @Then("User should be landed on OTP verification page")
    public void user_should_be_landed_on_otp_verification_page() throws Throwable {
    	String verification=URL+"-otp";
    	if (driver.getCurrentUrl().equalsIgnoreCase(verification)) {
    		System.out.println("User landed on OTP verification page");
    	}else {
    		System.out.println("Something went wrong");
    	}
        
    }

    @Then("Verify the user successfully logged in and landed on dashboard")
    public void verify_the_user_successfully_logged_in_and_landed_on_dashboard() throws Throwable {
    	Login.getverifyButton().click();
    	String dashboard="https://web-app-sit.briix.com/dashboard";
    	Thread.sleep(2000);
    	String dashboardURL=driver.getCurrentUrl();
    	if(dashboardURL.equalsIgnoreCase(dashboard)) {
    		System.out.println("User is successfully logged in");
    	}else{
    		String invalidOTP=Login.getinvalidOTP().getText();
    		System.out.println(invalidOTP+" is entered");
    	
    	}
    }

}
