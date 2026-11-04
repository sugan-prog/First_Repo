package com.omrbranch.report;
import java.io.File;

import java.util.ArrayList;

import java.util.List;



import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;



import com.omrbranch.utility.BaseClass;



import net.masterthought.cucumber.Configuration;

import net.masterthought.cucumber.ReportBuilder;


public class Reporting extends BaseClass {
	
	private static final Logger log = LogManager.getLogger(Reporting.class);



	public static void generateJvmReport(String jsonFile) {



	log.info("==========================================");

	log.info("JVM Report Generation Started");

	log.info("==========================================");



	try {



	// 1. JVM Report Path

	String jvmReportPath = getProjectPath() + "/target";



	File reportDirectory = new File(jvmReportPath);



	if (!reportDirectory.exists()) {

	reportDirectory.mkdirs();

	}



	log.info("JVM Report Path : {}", jvmReportPath);



	// 2. JSON Report Path

	File jsonReport = new File(jsonFile);



	if (!jsonReport.exists() || !jsonReport.isFile()) {

	throw new IllegalArgumentException("JSON Report Not Found : " + jsonFile);

	}



	log.info("JSON Report Path : {}", jsonFile);



	// 3. Log File Path

	String logFilePath = getProjectPath() + "/logs/automation.log";



	log.info("Log File Path : {}", logFilePath);



	// 4. Create Configuration Object

	Configuration configuration = new Configuration(reportDirectory, "OMR Branch Hotel Booking Automation");



	log.info("Report Configuration Created");



	// 5. Add Report Information

	configuration.addClassifications("Project Name", "HotelBookingAutomation_Name");
	configuration.addClassifications("Application", "OMR Branch");
	configuration.addClassifications("Browser Name", "Chrome");
	configuration.addClassifications("Browser Version", "154");
	configuration.addClassifications("OS", System.getProperty("os.name"));
	configuration.addClassifications("Environment", "QA");
	configuration.addClassifications("Testing Type", "Regression");
	configuration.addClassifications("Sprint", "34");
	configuration.addClassifications("Build Number", "Build-34.1");
	configuration.addClassifications("Tester Name", "Velmurugan");
	configuration.addClassifications("Execution Type", "Automation");
	log.info("Report Classifications Added Successfully");



	// 6. Create List for JSON Files

	List<String> jsonFiles = new ArrayList<String>();



	// 7. Add JSON File

	jsonFiles.add(jsonFile);



	log.info("JSON File Added to Report Builder");



	// 8. Create ReportBuilder Object

	ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);



	log.info("ReportBuilder Object Created");



	// 9. Generate JVM Report

	reportBuilder.generateReports();



	log.info("JVM Report Generated Successfully");

	log.info("JVM Report Available At : {}", jvmReportPath);

	log.info("Execution Logs Available At : {}", logFilePath);



	} catch (Exception e) {



	log.error("JVM Report Generation Failed", e);



	throw new RuntimeException("Unable to generate JVM Report", e);

	}



	log.info("==========================================");

	log.info("JVM Report Generation Completed");

	log.info("==========================================");

	}

	}

