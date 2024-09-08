package com.flipkarttask.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.flipkarttask.report.reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun=false, tags = "@ak",plugin= {"pretty","json:target\\index.json"}, glue = "com.flipkarttask.stepdefinition", features = "src\\test\\resources")

public class TestRunnerClass {
	@AfterClass
	public static void afterclass() {
		reporting.generateJvmReport("C:\\Users\\rathi\\eclipse-workspace\\FlipkartTask\\target\\index.json");
	}

}
