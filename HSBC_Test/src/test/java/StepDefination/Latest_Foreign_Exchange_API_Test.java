package StepDefination;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Factory.HomePage_Factory;
import TestBase.TestBaseClass;

public class Latest_Foreign_Exchange_API_Test extends TestBaseClass{

	HomePage_Factory homepage; 

	@BeforeTest
	public void StartUp(){
		TestBaseClass.InitilizeBrowser("Chrome", "https://ratesapi.io/documentation/");
		homepage = new HomePage_Factory();
	}
@   @Given("^$")
	@Test
	public void Test_API_Availabe(){
		String ExpectedAPI= "GET https://api.ratesapi.io/api/latest HTTP/2";
		String ActualAPIURl= homepage.API_Lates_Available();
		Assert.assertEquals(ActualAPIURl,ExpectedAPI,"Available API is not matching with expected API.");
		System.out.println("The API is available.");
	}

    @When()
	@Test
	public void Get_Responce(){
		String ActualResponce = homepage.Get_Lates_API_Response();
		Assert.assertTrue(ActualResponce.contains("base"),"The responce of API is not expected.");
		System.out.println("The responce of API is expected.");
	}

    @Then()
	@Test
	public void Incorrect_Link(){
		String Responce =	homepage.Incorrect_API_Response();
		Assert.assertFalse(Responce.contains("error"),"Incorrect url and Correct responese provided by call");
		System.out.println("API Url is corret.");
	}

	@AfterTest
	public void TearDown(){
		TestBaseClass.closeBrowser();
	}

}
