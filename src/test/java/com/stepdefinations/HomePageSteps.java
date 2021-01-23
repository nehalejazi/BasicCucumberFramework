package com.stepdefinations;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomePageSteps {
	
	private static String title;
	private static boolean registerlink;
	private static boolean polloptions;
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private HomePage homepage ;
	
	@Given("user is alreday logged into the application")
	public void user_is_alreday_logged_into_the_application(DataTable dataTable) {
		
		 List<Map<String,String>> credList= dataTable.asMaps();
		 String userName = credList.get(0).get("username");
		 String pwd = credList.get(0).get("password");
		 DriverFactory.getDriver().get("http://demowebshop.tricentis.com/login");
		 homepage=loginpage.doLogin(userName, pwd);
	  
	}
	@Given("User is on Homepage")
	public void user_is_on_homepage() {
		
	    title = homepage.getPageTitle();
	    
	}

	@When("user verify Register option")
	public void user_verify_register_option() {
	   registerlink =homepage.verifyRegisterLinkonHomepage();
	   System.out.println("Register link is :  "+registerlink);
	}

	@Then("Register option should not be visible")
	public void register_option_should_not_be_visible() {
	   Assert.assertEquals(false, registerlink);
	}

		
	@When("user verify Community poll option")
	public void user_verify_community_poll_option() {
		polloptions=homepage.pollOptions();
		System.out.println("Homepage polloption is : "+polloptions);
		Assert.assertTrue(polloptions);
	}

	@Then("Community poll options should be visible")
	public void community_poll_options_should_be_visible(DataTable optiontable) {
		
		List<String> expecteOptionTanle = optiontable.asList();
		System.out.println("Expecte Option list is : "+expecteOptionTanle);
		 
		List<String> actualList = homepage.gettingpolloptions();
		System.out.println("Actual Option list is : "+actualList);
		
		Assert.assertTrue(actualList.containsAll(expecteOptionTanle));
	}
	@Then("total number options should be {int}")
	public void total_number_options_should_be(Integer int1) {
		int size = homepage.totalnumerofpolloptions();
		System.out.println("Nehal Total no of option is :"+size);
		Assert.assertTrue(size==int1);
	   
	}

}
