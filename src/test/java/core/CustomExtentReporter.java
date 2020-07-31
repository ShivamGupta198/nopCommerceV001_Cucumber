/*
package core;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import groovy.beans.PropertyReader;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;

import java.io.File;

public class CustomExtentReporter {

    private ExtentHtmlReporter extentHtmlReporter;
    private ExtentReports extentReports;

    public CustomExtentReporter() {
        extentHtmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+ PropertyReader.getProperty().get("reporterPath")));
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
    }

    public void createTest(Scenario scenario)
    {
        if(scenario.getStatus()!=null)
        {
            switch (scenario.getStatus())
            {
                case PASSED:
                    extentReports.createTest(scenario.getName()).pass("passed");
                    break;
                case FAILED:
                    extentReports.createTest(scenario.getName()).fail("failed");
                    break;
                default:
                    extentReports.createTest(scenario.getName()).skip("skipped");
                    break;
            }
        }
    }

    public  void writeToReport()
    {
        if(extentReports!=null)
            extentReports.flush();
    }
}
*/
