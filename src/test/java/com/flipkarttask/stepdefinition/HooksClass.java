package com.flipkarttask.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass{
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		browserLaunch(getPropertyValues("browser"));
		getApplnUrl(getPropertyValues("url"));
		maximizeWindow();
		implicitWait();
		
	}
	@After
	public void afterScenario(Scenario scenario) {
		scenario.attach(takeScreenshot(), "images/png", "Every Scenario");
		quitBrowser();
	}

}
