package stepDefinitions;

import java.time.Duration;
import java.util.Scanner;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

import WebPortal.Briix_Admin.OpenBrowser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObject.Login_PageObject;

@RunWith(Cucumber.class)

public class Login_stepDefinition extends OpenBrowser {
	Login_PageObject Login;
	String URL;
	Scanner sc;
	public static String Browser;

	@Given("User is on login page by using {string}")
    public void user_is_on_login_page(String browserDriver) throws Throwable {
		Browser=browserDriver;
		driver=OpenBrowser.getDriver();
		Login=new Login_PageObject(driver);
		}

    @When("User provide a valid credentials {string} {string}")
    public void user_provide_a_valid_credentials(String userName, String password) throws Throwable {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30, 0));
    	Login.getuserName().sendKeys(userName);
    	Login.getpassword().sendKeys(password);
    	URL=driver.getCurrentUrl();
    	Login.getloginButton().click();       
    }
    @When("User click on forgot password link")
    public void user_click_on_forgot_password_link() throws Throwable {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30, 0));
    	Login.getforgotPassword().click();
    	
    	String Title="Forgot Password,";
    	if (Title.equalsIgnoreCase(Login.getforgotTitle().getText())) {
    		System.out.println("User landed on forgot password page");
    	}else {
    		System.out.println("Something went wrong");
    	}
    }
    @And("User should enter email {string}")
    public void user_should_enter_email(String email) throws Throwable {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30, 0));
    	Login.getuserName().sendKeys(email); 
    	Login.getsendLink().click();
    }

    @When("User provide the OTP")
    public void user_provide_the_otp() throws Throwable {
    	sc =new Scanner(System.in);
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
		
		Login.getverifyButton().click();
        
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
    @Then("Verify the message")
    public void verify_the_message() throws Throwable {
    	String message="We have sent a password reset instructions to your email If you haven’t recevied an email then click on “Resend Link”";
    	if (message.equalsIgnoreCase(Login.getconfirmationMessage().getText())) {
    		System.out.println("Message is Verified");
    	}else {
    		System.out.println("Something went wrong");
    	}
        
    }

    @Then("Verify the user successfully logged in and landed on dashboard")
    public void verify_the_user_successfully_logged_in_and_landed_on_dashboard() throws Throwable {
    	
    	String dashboard="https://webapp-sit.briix.com/dashboard";
    	Thread.sleep(2000);
    	String dashboardURL=driver.getCurrentUrl();
    	if(dashboardURL.equalsIgnoreCase(dashboard)) {
    		System.out.println("User is successfully logged in");
    	}else{
    		String invalidOTP=Login.getinvalidOTP().getText();
    		System.out.println(invalidOTP+" is entered");
    	
    	}
    	
    }
    @Then("Verify the message {string}")
    public void verify_the_message_something(String message) throws Throwable {
    	try {
      String Error=Login.geterrorMessage().getText();
      if(Error.equalsIgnoreCase(message)) {
    	  System.out.println(Error);
      }
      else {
    	  String anotherError=Login.getpasswordErrorMessage().getText();
    	  System.out.println(anotherError);
      }
    	}catch (Exception e) {
    	if(isAlertPresent()) {
    		System.out.println("Error Message is verified");
    	}
		}
    }
    
    public boolean isAlertPresent(){
		 try{
			 String anotherError=Login.getpasswordErrorMessage().getText();
	      	  System.out.println(anotherError);
		  return true;
		 }catch(Exception ex){
		String Error=Login.getincorrectPassword().getText();
		System.out.println(Error);
		  return false;
		 }
		}

}
