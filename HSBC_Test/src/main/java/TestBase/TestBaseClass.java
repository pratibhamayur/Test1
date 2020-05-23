package TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBaseClass {

	public static WebDriver driver=null;

	public static void InitilizeBrowser(String Browsername, String Website){

		switch(Browsername){
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("ignore-certificate-errors");
			options.setAcceptInsecureCerts(true);
			driver= new ChromeDriver(options);
			break;

		case "FireFox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "IE":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//Drivers//IEDriverServer.exe");
			driver= new InternetExplorerDriver();
			break;

		default:
			System.out.println("Browser name is not correct...");
			break;			
		}	

		driver.get(Website);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}

	public static void closeBrowser(){
		driver.close();
	}


}
