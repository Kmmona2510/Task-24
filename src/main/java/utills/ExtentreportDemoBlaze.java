package utills;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreportDemoBlaze {
	
	public static ExtentReports getreport() {
		
		//Create a Physical Report
		String path ="C:\\Users\\MOORTHI\\eclipse-workspace\\DemoBlaze\\reports\\DemoBalze.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("DemoBlaze Report");
		
		//Add automation data to physical report
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		return extent;
	}

}
