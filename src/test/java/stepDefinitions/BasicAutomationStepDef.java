package stepDefinitions;

import api_test.api_firstTest;
import components.CommonPageComponent;
import core.ConfigurationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import core.BaseDriver;
import core.LoginPage;
import org.openqa.selenium.By;

import java.io.IOException;

public class BasicAutomationStepDef extends BaseDriver {
	private LoginPage loginPage;
	private CommonPageComponent commonPageComponent;
	private api_firstTest apiFirstTest;
	public BasicAutomationStepDef(){

		loginPage = new LoginPage();
		commonPageComponent = new CommonPageComponent();
		apiFirstTest =new api_firstTest();
	}
	
	@Given("User Launch needed website")
	public void user_Launch_needed_website() {
		Assert.assertTrue("launch website",loginPage.launchMcAwithData());
	}

	@When("User Clicked on Registered Customers More Info")
	public void userClickedOnRegisteredCustomersMoreInfo() {
		commonPageComponent.getElementByHrefAndClass("/Admin/Customer/List","small-box-footer").click();
	}

	@Then("User Entered First Name")
	public void userEnteredFirstName() {
        loginPage.getInputBoxByName("SearchFirstName").sendKeys(getTestData().get("firstName"));
    }

    @And("User Clicked on Search")
    public void userClickedOnSearch() {
    commonPageComponent.clickById("search-customers");
	}

    @And("Validated nopCommerce script")
    public void validatedNopCommerceScript() {
		String scriptExpected = ConfigurationManager.getscriptConfiguration().get("premiumSupportServiceLink");
		String scriptActual = String.valueOf(getDriver().findElement(By.xpath("(//*[@class='panel-body'])[2]")).getText());
		Assert.assertEquals(scriptExpected,scriptActual);
	}

    @And("Validated api response")
    public void validatedApiResponse() throws IOException {
		apiFirstTest.testSamplePostRequest();
    }
}