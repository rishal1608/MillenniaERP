package org.ts.marketingautomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CountryStateCity {
	 static WebDriver driver;
	public CountryStateCity(WebDriver driver)
	{
		
		this.driver=driver;
	}
	
public static String Country()
	
	{
		WebElement countryWE= driver.findElement(By.id("ddlcountry"));
		if(countryWE.isDisplayed()||countryWE.isEnabled())
		{	
			countryWE.click();
            Select countrySelect= new Select(countryWE);
		    countrySelect.selectByVisibleText("Malaysia");
		}
		
		
		else System.out.println("Element not found");
		
		
		return "Malaysia";
	}
	

public static String State(String country)
	
	{
			WebElement stateWE= driver.findElement(By.id("ddlStatelist"));
			
			if(stateWE.isDisplayed()||stateWE.isEnabled())
			{	
				stateWE.click();
	            Select stateSelect= new Select(stateWE);
	            stateSelect.selectByVisibleText("Selangor");
			}
			
			else System.out.println("Element not found");	
			
			return "Selangor" ;
		}
			
		
public static void City(String state)

{
		WebElement cityWE= driver.findElement(By.id("ddlcitylist"));
		
		if(cityWE.isDisplayed()||cityWE.isEnabled())
		{	
			cityWE.click();
            Select citySelect= new Select(cityWE);
            citySelect.selectByVisibleText("Petaling Jaya");
		}
		
		else System.out.println("Element not found");	
	}
		
}



