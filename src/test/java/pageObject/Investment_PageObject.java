package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Investment_PageObject {
	WebDriver driver;
	
	public Investment_PageObject(WebDriver driver) {
	this.driver=driver;
	}
	
	By investment=By.xpath("//span[.='Investment']");
	public WebElement getinvestment() {
	return driver.findElement(investment);	
	}
	
	By filter=By.xpath("//*[@id=\"layout-wrapper\"]//div[2]/button");
	public WebElement getfilter() {
	return driver.findElement(filter);	
	}
	
	By pending=By.xpath("//label[.='Pending']");
	public WebElement getpending() {
	return driver.findElement(pending);	
	}
	
	By processed=By.xpath("//label[.='Processed']");
	public WebElement getprocessed() {
	return driver.findElement(processed);	
	}
	
	By cancelled=By.xpath("//label[.='Cancelled']");
	public WebElement getcancelled() {
	return driver.findElement(cancelled);	
	}
	
	By acceptButton=By.xpath("//button[.='Accept']");
	public WebElement getacceptButton() {
	return driver.findElement(acceptButton);	
	}
	
	By accept=By.xpath("/html/body/div[3]/div/div[1]/div/div/div[2]/div/div/div/div[1]/button");
	public WebElement getaccept() {
	return driver.findElement(accept);	
	}
	
	By confirmationMessage=By.xpath("//h3[.='Are you sure you want to Accept?']");
	public WebElement getconfirmationMessage() {
	return driver.findElement(confirmationMessage);	
	} 
	
	By searchText=By.xpath("//input[@type='text']");
	public WebElement getserachText() {
	return driver.findElement(searchText);	
	}
	
	By statusProcessed=By.xpath("//span[.='Processed']");
	public WebElement getstatusProcessed() {
	return driver.findElement(statusProcessed);	
	}
}
