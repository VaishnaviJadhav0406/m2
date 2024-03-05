package CommonUtills;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	
	ExtentReports report;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"Testscript execution is started",true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"Testscript execution is passed",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String message = result.getThrowable().toString();
		String methodname  = result.getMethod().getMethodName();
		Reporter.log(methodname+"Testscript execution is failed"+message,true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"Testscript execution is skipped",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
			}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	//	Reporter.log("Testscript execution is started",true);
	//	Reporter.log("Testscript execution is finished",true);
	
		// use ExtentSparkReporter class just to configure extent report
		
		JavaUtill jutil = new JavaUtill();
		ExtentSparkReporter reporter = new	ExtentSparkReporter("./extentreport/report"+jutil.getRandomNumber()+".html");
		reporter.config().setDocumentTitle("vtigercrm");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Organization");
		
		//use ExtentReports class to generate ExtentReports
		 report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("Browser", "chrome");
		report.setSystemInfo("chromeversion", "121");
		report.setSystemInfo("Author", "Vaishnavi");
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	   
		report.flush();
	
	}

}
