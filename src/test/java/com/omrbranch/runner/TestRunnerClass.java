package com.omrbranch.runner;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import org.junit.AfterClass;

import org.junit.BeforeClass;

import org.junit.runner.RunWith;

import com.omrbranch.report.Reporting;

import com.omrbranch.utility.BaseClass;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(

		features = "src/test/resources/features",

		// Step Definitions and Hooks

		glue = {

				"com.omrbranch.stepdefinition",

				"com.omrbranch.hooks"

		},

		// Reports

		plugin = {

				"pretty",

				"html:target/cucumber-report.html",

				"json:target/cucumber.json",

				"junit:target/cucumber.xml",

				"rerun:target/failed-scenarios.txt"

		},
		// Tags

		tags = "@Login",

		// Execution Configuration

		monochrome = true,

		dryRun = false,

		publish = false,

		stepNotifications = true

)
public class TestRunnerClass extends BaseClass {

	private static final Logger logger =

			LogManager.getLogger(TestRunnerClass.class);

	@BeforeClass

	public static void beforeClass() {

		logger.info("==========================================");

		logger.info("TestRunnerClass Execution Started");

		logger.info("Project : HotelBookingAutomation_Velmurugan");

		logger.info("Framework : Selenium Java + Cucumber BDD");

		logger.info("Execution Type : Automation");

		logger.info("==========================================");

	}

	@AfterClass

	public static void afterClass() {

		logger.info("==========================================");

		logger.info("TestRunnerClass Execution Completed");

		logger.info("JVM Report Generation Started");

		logger.info("==========================================");

		String jsonFile = getProjectPath() + "/target/cucumber.json";

		try {

			Reporting.generateJvmReport(jsonFile);

			logger.info("JVM Report Generation Completed Successfully");

		} catch (Exception e) {

			logger.error("JVM Report Generation Failed", e);

			throw e;

		}

		logger.info("==========================================");

		logger.info("TestRunnerClass Execution Ended");

		logger.info("==========================================");

	}

}
