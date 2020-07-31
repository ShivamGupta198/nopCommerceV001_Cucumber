package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/*import org.openda.selenium.chrome.ChromeDriver;
import org.openga.selenium.chrome.Chromeoptions;
import org.openga.selenium.edge.EdgeDriver;
import org.openga.selenium.firefox.FirefoxDriver;
import org.openda.selenium.firefox.Firefoxoptions;
import org.openda.selenium.remote.CapabilityType; 
import org.openda.selenium.remote.DesiredCapabilities; 
import org.openga.selenium.remote.RemoteWebDriver;*/
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
	private DriverFactory() {
	}

	public static WebDriver createInstance(String browserName) {

		WebDriver driver = null;
		String machineName = "BDSPUKDO0077115";
		if (browserName.toLowerCase().contains("remote")) {
			Map<String, Object> prefs = new HashMap<String, Object>();
			// Set the notification setting it will override the default setting
			prefs.put("profile.default_content_setting_values.notifications", 2);
			
			// create object of ChromeOption class
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			options.setExperimentalOption("useAutomationExtension", false);
			// Set the experimental option. -
			options.setExperimentalOption("prefs", prefs);
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			capability.setCapability(ChromeOptions.CAPABILITY, options);
			try {
				driver = new RemoteWebDriver(new URL("http://" + machineName + ":10501/wd/hub"), capability);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			return driver;
		}

		if (browserName.toLowerCase().contains("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.setBinary(System.getProperty("webdriver.firefox.bin"));
			driver = new FirefoxDriver(options);
			return driver;
		}
		if (browserName.toLowerCase().contains("edge")) {
			driver = new EdgeDriver();
			return driver;
		}
		if (browserName.toLowerCase().contains("chrome")) {
			System.out.println("value is...." + System.getProperty("webdriver.chrome.driver"));
			System.setProperty("webdriver.chrome.driver", System.getProperty("webdriver.chrome.driver"));
			ChromeOptions options = new ChromeOptions();
			options.setBinary("c:\\Program Files (x86)\\Google\\chrome\\Application\\chrome.exe");
			options.addArguments("--disable-extensions");
			options.setExperimentalOption("useAutomationExtension", false);
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new ChromeDriver(options);
			return driver;
		}
		return driver;
	}
}