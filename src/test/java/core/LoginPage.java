package core;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BaseDriver {
	private WebDriver driver;
	private static final String XUSERID = "X-UserId";
	private static final String XCUSTOMERID = "X-CustomerId";
	private static final String XSESSIONID = "X-SessionId";

	public LoginPage() {
		driver = getDriver();

	}

	public boolean launchMCA(String processID, Map<String, String> headers) {
		boolean flag = false;
		if (System.getProperty("browser").equalsIgnoreCase("remote")) {
			launchMcAwithData();
		} else {
			String url = ConfigurationManager.getBundle().get("secure_proxy") + processID;
			// String token =
			// agentProfileservice.getToken(headers.get(XUSERID));
			driver.navigate().to(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			flag = true;
		}
		return flag;
	}

	public boolean launchMcAwithData(){
			String env=System.getProperty("env");
			System.out.println(ConfigurationManager.getBundle().get("website_url"));
			driver.navigate().to(ConfigurationManager.getBundle().get("website_url"));
			
			getInputBoxByID("Email").clear();
			System.out.println("@@ " + getTestData().get("loginID"));
			getInputBoxByID("Email").sendKeys (getTestData().get("loginID"));
			getInputBoxByID("Password").clear();
			getInputBoxByID("Password").sendKeys (getTestData().get("password"));
			getDriver().findElement(By.xpath("//input[@value='Log in']")).click();


	/*
				Not needed
				driver.navigate().to(ConfigurationManager.getBundle().get("mcalauncher_url"));
				Select s = new Select(getInputBoxByName("environment"));
				s.selectByVisibleText(ConfigurationManager.getBundle().get("mcasecureproxy_url"));
				getInputBoxByName("launchid").sendKeys(getTestData().get("launchid"));
				getInputBoxByName("X-AccountId").sendKeys (getTestData().get("X-AccountId"));
				getInputBoxByName("X-Applicationid").sendKeys (getTestData().get("X-Applicationid"));
				getInputBoxByName("x-Payment Instrumentid").sendKeys(getTestData().get("X-Paymentinstrumentid"));
				getInputBoxByName(XUSERID).sendKeys (getTestData().get(XUSERID));
				getInputBoxByName(XCUSTOMERID).clear();
				getInputBoxByName(XCUSTOMERID).sendKeys(getTestData().get(XCUSTOMERID));
				getInputBoxByName("THEME").sendKeys ("projname-uk");
				if (getTestData().isMapped (XSESSIONID)) {
					getInputBoxByName (XSESSIONID). clear();
					getInputBoxByName (XSESSIONID).sendKeys(getTestData().get(XSESSIONID));
				}
				if (env.equalsIgnoreCase("qa03")){
				//	String token = agentProfileservice.getToken(getTestData().get(XUSERID));
					getInputBoxByName("X-SsoToken").clear();
				//	getInputBoxByName("X-SsoToken").sendKeys(token);
				}
				getDriver().findElement(By.xpath("//input[@value='LAUNCH']")).click();*/






				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				return true;
				}

		public WebElement getInputBoxByName(String name) {
		return getDriver().findElement(By.name(name));
		}

		private WebElement getInputBoxByID(String id) {
		return getDriver().findElement(By.id(id));
		}
	public boolean waitfor(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		return true;
	}

	public boolean waitForLoaderTodismisss(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		return true;
	}

	public boolean isElementExist(String tag, String value) {
		WebElement webElement;
		By locator = By.xpath(String.format("//%s [text()= '%s']", tag, value));
		webElement = getDriver().findElement(locator);
		return webElement.isEnabled();
	}
}
