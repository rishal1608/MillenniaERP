package org.ts.marketingautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.ts.marketingautomation.pages.HomePage;
import org.ts.marketingautomation.pages.LoginPage;
import org.ts.marketingautomation.pages.ManageListPage;
//import org.tq.openmrs.pages.ManageServiceTypesPage;
import org.ts.ma.util.AppLibrary;
import org.ts.ma.util.TestBaseClass;

public class ManageServiceTypesTests extends TestBaseClass{

	@Parameters({"Username","Password"})
	@BeforeTest
	public void login(String username,String password) throws InterruptedException
	{
		driver.get(url);
		LoginPage lPage = new LoginPage(driver);
		System.out.println("UserName" + username);
		System.out.println("Password" + password);
		String actual = lPage.login(username,password);
		Assert.assertTrue(actual.contains("TECHNO SOFT"));
	}
	@Test(priority=1)
	public void verifyAddList() throws InterruptedException
	{
		
		HomePage hPage = new HomePage(driver);
		hPage.navigatetoDashboard();
		hPage.navigatetoList();
		String lName = AppLibrary.randomListName();
		String dEmailAddress=AppLibrary.randomDefaultEmail();
		String dName=AppLibrary.randomDefaultName();
		String dcompany=AppLibrary.randomCompany();
		String address=AppLibrary.randomAddress();
		String postcode= AppLibrary.randomZipcode();
		String phoneno=AppLibrary.randomPhone();
		ManageListPage listname = new ManageListPage(driver);
		System.out.println("Adding the List Name:::"+ lName);
		listname.AddList(lName,dEmailAddress,dName, dcompany, address,postcode,phoneno);
		Thread.sleep(2000);
		boolean result = listname.verifyList(lName);
		Assert.assertTrue(result);
		Thread.sleep(2000);
		hPage.navigatebacktoDashboard();
	}
	@Test(priority=2)
	 public void verifyAddSubscriber() throws InterruptedException {
		
		
		HomePage hPage = new HomePage(driver);
		hPage.navigatetoDashboard();
		hPage.navigatetoList();
		
		String subscriberEmail=AppLibrary.randomDefaultEmail();
		String sFName=AppLibrary.randomDefaultName();
		String sLName=AppLibrary.randomListName();
		ManageListPage listSubscriber = new ManageListPage(driver);
		listSubscriber.AddSubscriber(subscriberEmail, sFName, sLName);
		System.out.println("Adding the Subscriberdetails :::"+ subscriberEmail+sFName+sLName);
		Thread.sleep(2000);
		boolean result=listSubscriber.verifyAddSubscriber(subscriberEmail);	
		System.out.println(subscriberEmail);
		Assert.assertTrue(result);
		hPage.navigatebacktoDashboard();
	}
	@AfterSuite
	public void logoutApp()
	{
		HomePage hPage = new HomePage(driver);
		hPage.logoutApp();
	}
}
	