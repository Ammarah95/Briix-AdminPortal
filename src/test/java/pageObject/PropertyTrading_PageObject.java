package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PropertyTrading_PageObject {
	WebDriver driver;
	public PropertyTrading_PageObject(WebDriver driver) {
		this.driver=driver;
	}
	
By propertyTrading=By.xpath("//a[@href='/property-trading']");
public WebElement getpropertyTrading() {
return driver.findElement(propertyTrading);	
}

By filterStatus=By.xpath("//i[@class='mdi mdi-filter']");
public WebElement getfilterStatus() {
return driver.findElement(filterStatus);	
}

}
