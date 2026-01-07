package stepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@CucumberOptions(features = "D:\\eclipse-workspace\\parabank-selenium-automation\\src\\test\\resources\\Features", glue = "stepDefinitions", 
//plugin = {
//		"pretty", // console output
//		"html:target/cucumber-reports.html", // HTML report
//		"json:target/cucumber.json" // JSON report
//}, monochrome = true // cleaner console output
//)

@CucumberOptions(features = "D:\\eclipse-workspace\\parabank-selenium-automation\\src\\test\\resources\\Features", glue = "stepDefinitions", plugin = {
		"pretty", "html:target/cucumber-reports.html" }, tags = "@smokeTest")

public class TestRunner extends AbstractTestNGCucumberTests {

}
