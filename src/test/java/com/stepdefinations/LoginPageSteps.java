package com.stepdefinations;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private static String title;
	private static boolean link;
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());

	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("http://demowebshop.tricentis.com/login");
	}

	@When("user get the page title")
	public void user_gets_the_titleof_the_page() {
		title = loginpage.getLoginPageTitle();
		System.out.println("Page title is : "+title); 
	}

	@Then("Page title is {string}")
	public void title_of_the_page_should_be(String expectedLoginPagetitle) {
		
		Assert.assertTrue(title.contains(expectedLoginPagetitle));
	   
	}

	@When("user verify forgot password link")
	public void user_verify_forgot_password_link() {
	  link= loginpage.isForgotPasswordlinkpresent();
	  System.out.println("Status of forgot password link: "+link);
	}

	@Then("Forgor password link should be availble")
	public void forgor_password_link_should_be_availble() {
		Assert.assertTrue(link);
	}

	@When("user enter username as {string}")
	public void user_enter_username_as(String username) {
	    loginpage.enterUserName(username);
	}

	@When("user enter password as {string}")
	public void user_enter_password_as(String password) {
	   loginpage.enterPassword(password);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
	   loginpage.clickLoginButton();
	}

	
}
