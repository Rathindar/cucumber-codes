package com.flipkarttask.stepdefinition;


import org.junit.Assert;

import com.flipkarttask.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_UserRegistrationstep {
	PageObjectManager pom = new PageObjectManager();

	
	@Given("User is on flipkart page")
	public void user_is_on_flipkart_page() {
	
	}
	@When("User clicks login button")
	public void user_clicks_login_button() {
		pom.getLoginPage().clicklogin();
	
	}
	@Then("User enters phone number {string}")
	public void user_enters_phone_number(String string) {
		pom.getLoginPage().enterphoneno(string);
		
	
	}
	@When("User enters valid OTP")
	public void user_enters_valid_otp() throws InterruptedException {
		Thread.sleep(25000);
	
	}
	@Then("User should verify login sucess msg {string}")
	public void user_should_verify_login_sucess_msg(String string) {
		String loginsucessmsg = pom.getLoginPage().loginsucessmsg();
		Assert.assertEquals("verify login sucess msg", string, loginsucessmsg);
		
	
	}




}
