package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By userNameelement = By.xpath("//input[@id='Email']");
	private By passwordelement = By.xpath("//input[@id='Password']");
	private By loginButtonelement = By.xpath("//input[@type='submit' and @value='Log in']");
	private By forgotpwdelement = By.xpath("//a[normalize-space()='Forgot password?']");
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isForgotPasswordlinkpresent()
	{
		return driver.findElement(forgotpwdelement).isDisplayed();
	}
	
	public void enterUserName(String username)
	{
		driver.findElement(userNameelement).sendKeys(username);
	}
	public void enterPassword(String password)
	{
		driver.findElement(passwordelement).sendKeys(password);
	}
	public void clickLoginButton()
	{
		driver.findElement(loginButtonelement).click();
		//return HomePage.class;;
	}
	public HomePage doLogin(String userName,String pwd)
	{
		driver.findElement(userNameelement).sendKeys(userName);
		driver.findElement(passwordelement).sendKeys(pwd);
		driver.findElement(loginButtonelement).click();
		return new HomePage(driver);
	}

}
