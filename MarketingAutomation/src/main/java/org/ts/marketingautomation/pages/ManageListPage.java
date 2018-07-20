package org.ts.marketingautomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ManageListPage {

	WebDriver driver;
	public ManageListPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public boolean verifyList(String lName)
	{
		boolean result = false;
		
		
		//List<WebElement> pagesList = driver.findElements(By.xpath(".//*[@id='sortable']/li/div"));
		List<WebElement> liList = driver.findElements(By.xpath(".//*[@id='sortable']/li/div"));
		outer:
		for(int j=0;j<liList.size();j++)
			{
				if(liList.get(j).getText().contains(lName))
				{
					System.out.println("ListName Found");
					result = true;
					break outer; 
				}
			}
			//pagesList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a"));
			//pagesList.get(i+1).click();
			//liList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable']/tbody/tr/td[1]"));
		
		
		return result;
	}
	
	
	
	
	public void AddList(String lName, String dEmailAddress, String dName, String dcompany, String address, String postcode, String phoneno) throws InterruptedException
	{
		Thread.sleep(2500);
		driver.findElement(By.linkText("Create List")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("txtlistname")).clear();
		driver.findElement(By.id("txtlistname")).sendKeys(lName);
		driver.findElement(By.id("txtdefaultemail")).sendKeys(dEmailAddress);
		driver.findElement(By.id("txtdefaultname")).sendKeys(dName);
		driver.findElement(By.id("txtorganizationname")).sendKeys(dcompany);
		driver.findElement(By.id("txtaddress")).sendKeys(address);
		CountryStateCity CSC= new CountryStateCity(driver);
		String cName=CSC.Country();// to get the country name value
		String sName=CSC.State(cName);// to get the state name value
		CSC.City(sName);
		driver.findElement(By.id("txtphoneno")).sendKeys(phoneno);;
		driver.findElement(By.id("ddlpostcodelist")).sendKeys(postcode);
		driver.findElement(By.id("txtdescription")).sendKeys("Script written for testing the list functionality so that regression time will get save when new build is uploaded");
		driver.findElement(By.xpath(".//*[@id='CreateListForm']/div/div/div[8]/div[1]/label")).click();
		driver.findElement(By.xpath(".//*[@id='CreateListForm']/div/div/div[8]/div[2]/label")).click();
		driver.findElement(By.className("btn-success")).submit();
		/*List<WebElement> list= driver.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println("List of Items " + list.size());
	for(int i=0;i<list.size();i++)
	{		
		//if(list.size()>0)
		
		WebElement e1=list.get(0);
		e1.click();
		
		
	}	*/
		//driver.findElements(By.cssSelector("input[value='Save']"));
		
	}

	
	public void AddSubscriber(String subscriberEmail, String sFName, String sLName) throws InterruptedException
	{
		
		
		driver.findElement(By.xpath(".//*[@id='headingTwo-51']/a[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("subscriberemail")).sendKeys(subscriberEmail);
		driver.findElement(By.id("subscriberfirstname")).sendKeys(sFName);
		driver.findElement(By.id("subscriberlastname")).sendKeys(sLName);
		driver.findElement(By.className("btn-success")).submit();
		
	}
	
	
	public boolean verifyAddSubscriber(String subscriberEmail) throws InterruptedException
	{
		
		boolean result=false;
		 driver.findElement(By.linkText("Pe10011")).click();
		 Thread.sleep(1000);
		 
		WebElement noSubscriber= driver.findElement(By.xpath("html/body/main/section/div/div[4]/div/div/table"));
		
		if(!noSubscriber.equals(noSubscriber))
		{
			
			System.out.println("No Subscribers in the list");
		}
		
		else
		{
			List<WebElement> trSubscriber = driver.findElements(By.xpath(".//*[@id='memberListPartial']/div/div/table/tbody/tr"));
			List<WebElement> tdSubscriber = driver.findElements(By.xpath(".//*[@id='memberListPartial']/div/div/table/tbody/tr/td"));
			outer:
			for(int i=0;i<trSubscriber.size();i++)
			{
				for(int j=0;j<tdSubscriber.size();j++)
				{
					
					if(tdSubscriber.get(j).getText().contains(subscriberEmail))
					{
						
						System.out.println(subscriberEmail);
						System.out.println("Subscriber Found");
						result = true;
						break outer; 
					}
				}
				
			}
			
		}
		return result;
	}
}
