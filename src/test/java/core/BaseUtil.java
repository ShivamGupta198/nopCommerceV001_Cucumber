package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BaseUtil {
    private WebDriver driver;

    File customerFilePath = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\%s.csv");


    @Before
    public void beforescenario(Scenario scenario  ) throws IOException {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "DEBUG");
        ConfigurationManager.loadProperties(System.getProperty("env"));
        String tags = scenario.getSourceTagNames().toString();
        String scenarioId =scenario.getId().split("Features/")[1];

        String featureName =scenarioId.split(".feature")[0];

        String testcase = tags.replaceAll("\\[|\\]|@", "");

        System.out.println("testcase = [" + testcase + "]");
        if (testcase.contains("datadriven")) {

            testcase = scenario.getName().split(" ")[scenario.getName().split(" ").length - 1];
            System.out.println("select test case = [" + testcase + "]");
        }

        else {
            for (String selecttestCase : testcase.split(",")) {

                if (selecttestCase.trim().startsWith("us")) {
                    testcase = selecttestCase.trim();
                    System.out.println("select test case = [" + testcase + "]");
                    break;
                }
            }
        }

        if (testcase. contains ("scripttag")){
            testcase= testcase.startsWith("scripttag") ? testcase.split(",")[1].trim():testcase.split(",")[0].trim();
        }

        CSVRecord record = CsvDataReader.readTestDataFromFile(String.format(String.valueOf(customerFilePath), featureName), testcase);

        BaseDriver.setTestData(record);

        driver = DriverFactory.createInstance(System.getProperty("browser"));
        BaseDriver.setDriver(driver);
        driver.manage().window().maximize();
    }

    @Before("@scripttag")
    public void loadScriptValuesBeforeScenario() throws FileNotFoundException, InterruptedException
    {
        ConfigurationManager.loadProperties("script");
    }

    @After
    public void afterscenario(Scenario scenario) throws IOException {
        WebDriver driver = BaseDriver.getDriver();
        scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES),"image/png","screenshotCaptured");
        if (driver != null) {
//			driver.quit();
        }
    }
}
