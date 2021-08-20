package WebPortal.Briix_Admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import stepDefinitions.Login_stepDefinition;

public class OpenBrowser {
	public static WebDriver driver;
	public static Properties prop;
	public static ChromeOptions options;
	public static FileInputStream fis;
	static String browserName;
	
	public static WebDriver getDriver() throws IOException {
		prop = new Properties();
		fis = new FileInputStream("src/test/java/WebPortal/Briix_Admin/global.properties");
		prop.load(fis);
		if (Login_stepDefinition.Browser.equalsIgnoreCase("chrome")) {
		ChromeOptions option=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		option.addArguments("--silent");
		}else if(Login_stepDefinition.Browser.equalsIgnoreCase("firefox")){
			FirefoxOptions option=new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(option);
			option.addArguments("--silent");
		}else if (Login_stepDefinition.Browser.equalsIgnoreCase("edge")) {
			EdgeOptions option=new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(option);
			option.addArguments("--silent");
		}

		else {
			ChromeOptions option=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
			option.addArguments("--silent");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60, 0));
		driver.get(prop.getProperty("URL"));
		
		driver.manage().window().maximize();
		return driver;
	}
}
