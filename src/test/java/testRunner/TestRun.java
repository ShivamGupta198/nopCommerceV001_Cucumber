package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions
		(
				features= {".//Features/"},
				glue = {"stepDefinitions","core"},
				dryRun=false,
				monochrome=true ,
                plugin= {"html:target/defaultCucumberReport.html","json:target/cucumber-reports/cucumber.json"},
				tags ="@basicTests"

		)

public class TestRun {


}
