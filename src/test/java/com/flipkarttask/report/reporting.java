package com.flipkarttask.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class reporting {
	public static void generateJvmReport(String jsonFile) {
		//1
		File file=new File("C:\\Users\\rathi\\eclipse-workspace\\FlipkartTask\\target");
		
		//2
		Configuration configuration=new Configuration(file,"Flipkart Automation");

		//3
		configuration.addClassifications("Browser Name", "Chrome");
		configuration.addClassifications("Browser Version", "126");
		configuration.addClassifications("os", "win 11");
		configuration.addClassifications("Sprint", "35");
		
		//4
		List<String>jsonFiles=new ArrayList<>();
		jsonFiles.add(jsonFile);
		ReportBuilder builder=new ReportBuilder(jsonFiles,configuration);
		
		//5
		builder.generateReports();

	}


}
