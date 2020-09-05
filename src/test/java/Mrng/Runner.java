package Mrng;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles",
glue= "stepDefinitions",
tags= {"@scenariowithDatatable"},
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:Reports/report.html", "html:target/cucumber-reports"}
//,monochrome = true
//,dryRun=true
)
public class Runner extends AbstractTestNGCucumberTests {

}