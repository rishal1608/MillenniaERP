package org.ts.marketingautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public String login(String username,String password) throws InterruptedException
	{
		driver.findElement(By.id("UserName")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);
		String msg = driver.findElement(By.xpath(".//*[@id='admin-bodyPM']/main/header/div[2]/h4/a")).getText();
		return msg;
	}
	
	public String forgot(String email)
	{
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("loginButton")).click();
		String msg = driver.findElement(By.xpath(".//*[@id='loginForm']/div/div/div[2]/div[2]/div[4]/label")).getText();
		return msg;
		
		
		
	}
}
