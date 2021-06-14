package WebPortal.Briix_Admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

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
		ChromeOptions option=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		option.addArguments("--silent");

		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60, 0));
		driver.get(prop.getProperty("URL"));
		
		driver.manage().window().maximize();
		return driver;
	}
}
