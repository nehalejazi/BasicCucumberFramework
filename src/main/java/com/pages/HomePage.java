package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private WebDriver driver;
	
	private By registerLink = By.xpath("//input[@value='Register']");
	private By communityPolloption = By.xpath("//strong[normalize-space()='Community poll']");
	private By noofCommunityPollOption = By.cssSelector("ul[class='poll-options']>li>label");
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyRegisterLinkonHomepage()
	{
		return driver.findElement(registerLink).isDisplayed();
	}
	
	public boolean pollOptions()
	{
		return driver.findElement(communityPolloption).isDisplayed();
	}
	
	public List<String> gettingpolloptions()
	{
		List<String> options = new ArrayList<>();
		
		List<WebElement> optionheader= driver.findElements(noofCommunityPollOption);
		for(WebElement e:optionheader)
		{
			String text = e.getText();
			System.out.println(text);
			options.add(text);
			
		}
		return options;
	}
	public int totalnumerofpolloptions()
	{
		return driver.findElements(noofCommunityPollOption).size();
	}

}
