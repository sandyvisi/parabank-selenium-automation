package utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsUtility implements ITestListener {

	public ExtentSparkReporter extentsparkReporter;

	public ExtentReports extentReports;

	public ExtentTest extentTest;

	public SimpleDateFormat df;

	public Date date;

	public String reportName;

	List<String> groups;

	@Override
	public void onStart(ITestContext context) {

		df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

		date = new Date();

		String currentTimeStamp = df.format(date);

		reportName = "Test-Report-" + currentTimeStamp + ".html";

		extentsparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\ExtentReports\\testreport.html");

		extentsparkReporter.config().setDocumentTitle("automation test report");

		extentsparkReporter.config().setReportName("login report");

		extentsparkReporter.config().setTheme(Theme.DARK);

		extentReports = new ExtentReports();

		extentReports.attachReporter(extentsparkReporter);

		extentReports.setSystemInfo("Application", "Registration");
		extentReports.setSystemInfo("Module", "Registration Module");
		extentReports.setSystemInfo("Sub-Module", "Register Info");
		extentReports.setSystemInfo("Application", "Registration");
		extentReports.setSystemInfo("Application", "Registration");

		extentReports.setSystemInfo("user name", System.getProperty("user.name"));
		extentReports.setSystemInfo("Environment", "QA");
		extentReports.setSystemInfo("TesterName", "santhosh");

		String os = context.getCurrentXmlTest().getParameter("os");
		extentReports.setSystemInfo("os", os);

		String chrome = context.getCurrentXmlTest().getParameter("browser");
		extentReports.setSystemInfo("Browser", chrome);

		groups = context.getCurrentXmlTest().getIncludedGroups();

		if (!groups.isEmpty()) {

			extentReports.setSystemInfo("Groups", groups.toString());
		}

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest = extentReports.createTest(result.getTestClass().getName());
		extentTest.assignCategory(result.getMethod().getGroups());

		extentTest.log(Status.PASS, "TEST CASE IS PASSED " + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest = extentReports.createTest(result.getTestClass().getName());
		extentTest.assignCategory(result.getMethod().getGroups());

		extentTest.log(Status.FAIL, "test is failed " + result.getName() + " got failed");

		extentTest.log(Status.INFO, result.getThrowable().getMessage());

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.SKIP, "test is skipped " + result.getName());

	}

	@Override
	public void onTestStart(ITestResult result) {

		extentTest = extentReports.createTest(result.getName());

		extentTest.log(Status.INFO, "test is started " + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		System.out.println(result.getName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();

	}

}
