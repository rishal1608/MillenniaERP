package org.ts.marketingautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void navigatetoDashboard() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='admin-bodyPM']/main/section/div/a[2]/span[2]")).click();
		
	}
	public void navigatebacktoDashboard() throws InterruptedException
	{
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Techno Soft")).click();
	}
	public void navigatetoList() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.linkText("Lists")).click();
		
	}
	public void navigatetoCampaigns()
	{
		driver.findElement(By.linkText("Campaigns")).click();
		
	}
	public void navigatetoTemplates()
	{
		driver.findElement(By.linkText("Templates")).click();
		
	}
	public void navigatetoReports()
	{
		driver.findElement(By.linkText("Reports")).click();
		
	}
	public void logoutApp()
	{
		driver.findElement(By.id("User_Avtar_initials")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

}
