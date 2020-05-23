package Page_Factory;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import TestBase.TestBaseClass;

public class SpecificDate_PageFactory extends TestBaseClass {

	public String API_Specific_Available(){
		driver.findElement(By.xpath("//div/ul[1]/li/a[text()='Date']")).click();
		WebElement API= driver.findElement(By.xpath("//div[@id='specific-date']/p[2]"));
		String APIlink= API.getText();
		Boolean Available = API.isDisplayed();
		if(Available){
			System.out.println("API is displayed.");
		}
		else{
			System.out.println("API is not displayed.");
		}
		return APIlink;
	}

	public String Get_Lates_API_Response(){
		String responce="";
		String APIlink= driver.findElement(By.xpath("//div[@id='specific-date']/p[2]")).getText();
		String[] Newlink = APIlink.split(" ");
		System.out.println("API link is "+Newlink[1]);

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); //switches to new tab
		driver.get(Newlink[1]);
		try {
			synchronized (driver)
			{
				driver.wait(2000);
			}
			responce = driver.findElement(By.xpath("//pre")).getText();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return responce;

	}

	public String Incorrect_API_Response(){
		String responce="";
		String APIlink= driver.findElement(By.xpath("//div[@id='specific-date']/p[2]")).getText();
		String[] Newlink = APIlink.split(" ");
		System.out.println("API link is "+Newlink[1]);

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); //switches to new tab
		driver.get(Newlink[1]);
		try {
			synchronized (driver)
			{
				driver.wait(2000);
			}
			responce = driver.findElement(By.xpath("//pre")).getText();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return responce;
	}


}
