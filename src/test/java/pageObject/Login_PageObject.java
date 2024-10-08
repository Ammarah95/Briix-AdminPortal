package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_PageObject {
		WebDriver driver;
		public Login_PageObject(WebDriver driver) {
			this.driver=driver;
		}
		
By userName=By.id("email");
	public WebElement getuserName() {
	return driver.findElement(userName);	
	}
	
By password=By.id("password");
	public WebElement getpassword() {
	return driver.findElement(password);	
	}
	
By sendLink=By.xpath("//button[.='Send Link']");
	public WebElement getsendLink() {
	return driver.findElement(sendLink);	
	}	
	
By loginButton=By.xpath("//button[.='Login']");
	public WebElement getloginButton() {
	return driver.findElement(loginButton);	
	}
	
By OTPvalue1=By.xpath("//*[@id=\"root\"]//input[1]");
	public WebElement getOTPvalue1() {
	return driver.findElement(OTPvalue1);	
	}
	
By OTPvalue2=By.xpath("//*[@id=\"root\"]//input[2]");
	public WebElement getOTPvalue2() {
	return driver.findElement(OTPvalue2);	
	}
	
By OTPvalue3=By.xpath("//*[@id=\"root\"]//input[3]");
	public WebElement getOTPvalue3() {
	return driver.findElement(OTPvalue3);	
	}
	
By OTPvalue4=By.xpath("//*[@id=\"root\"]//input[4]");
	public WebElement getOTPvalue4() {
	return driver.findElement(OTPvalue4);	
	}
	
By OTPvalue5=By.xpath("//*[@id=\"root\"]//input[5]");
	public WebElement getOTPvalue5() {
	return driver.findElement(OTPvalue5);	
	}
	
By OTPvalue6=By.xpath("//*[@id=\"root\"]//input[6]");
	public WebElement getOTPvalue6() {
	return driver.findElement(OTPvalue6);	
	}	

By verifyButton=By.xpath("//button[.='Verify']");
	public WebElement getverifyButton() {
	return driver.findElement(verifyButton);	
	}	
	
By invalidOTP=By.xpath("//p[.='Invalid OTP']");
	public WebElement getinvalidOTP() {
	return driver.findElement(invalidOTP);	
	}
	
By errorMessage=By.xpath("//*[@id='email-helper-text']");
	public WebElement geterrorMessage() {
	return driver.findElement(errorMessage);	
	}
By passwordErrorMessage=By.xpath("//*[@id='password-helper-text']");
	public WebElement getpasswordErrorMessage() {
	return driver.findElement(passwordErrorMessage);	
	}	
	
By incorrectPassword=By.xpath("//*[@class='MuiTypography-root MuiTypography-body1']");
	public WebElement getincorrectPassword() {
	return driver.findElement(incorrectPassword);	
	}
	
By forgotPassword=By.xpath("//a[.='Forgot Password?']");
	public WebElement getforgotPassword() {
	return driver.findElement(forgotPassword);	
	}
	
By forgotTitle=By.xpath("//h5[.='Forgot Password,']");
	public WebElement getforgotTitle() {
	return driver.findElement(forgotTitle);	
	}
	
By confirmationMessage=By.xpath("//p[.='We have sent a password reset instructions to your email If you haven’t recevied an email then click on “Resend Link”']");
	public WebElement getconfirmationMessage() {
	return driver.findElement(confirmationMessage);	
	}
}
