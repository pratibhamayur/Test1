package Test_Cases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Page_Factory.HomePage_Factory;
import Page_Factory.SpecificDate_PageFactory;
import TestBase.TestBaseClass;
import Utility.ExcelData;

public class Specific_date_API_test {

	SpecificDate_PageFactory specificpage; 

	@BeforeTest
	public void StartUp(){
		TestBaseClass.InitilizeBrowser("Chrome", "https://ratesapi.io/documentation/");
		specificpage = new SpecificDate_PageFactory();
	}

	@Test
	public void Test_API_Availabe(){
		String ExpectedAPI= "GET https://api.ratesapi.io/api/2010-01-12";
		String ActualAPIURl= specificpage.API_Specific_Available();
		Assert.assertEquals(ActualAPIURl,ExpectedAPI,"Available API is not matching with expected API.");
		System.out.println("The orrect API is available.");
	}

	@Test()
	public void Get_Responce(){
		String ActualResponce = specificpage.Get_Lates_API_Response();
		Assert.assertTrue(ActualResponce.contains("base"),"The responce of API is not expected.");
		System.out.println("The responce of API is expected.");
	}

	@Test
	public void Incorrect_Link(){
		String Responce =	specificpage.Incorrect_API_Response();
		Assert.assertFalse(Responce.contains("error"),"Incorrect url and Correct responese provided by call");
		System.out.println("API Url is corret.");
	}

	@AfterTest
	public void TearDown(){
		TestBaseClass.closeBrowser();
	}


}
