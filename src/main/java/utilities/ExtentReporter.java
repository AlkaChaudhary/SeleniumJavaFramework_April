package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
		public static ExtentReports extentReport;
		public static ExtentReports getExtentReport() {
    	  String path=System.getProperty("user.dir")+"\\reports\\extentReports.html";
    	  ExtentSparkReporter reporter= new ExtentSparkReporter(path);
    	  reporter.config().setDocumentTitle("Framework Report");
    	  reporter.config().setReportName("Test Results");
    	  extentReport = new ExtentReports();
  		  extentReport.attachReporter(reporter);
  		  extentReport.setSystemInfo("operating System", "Windows11");
  		  extentReport.setSystemInfo("Java Version", "17.0.6");
  		  extentReport.setSystemInfo("Selenium version", "4.7.2");
  		  extentReport.setSystemInfo("Tested By", "Alka");
  		    
  		  return extentReport;
  		   	  	
      }
}
