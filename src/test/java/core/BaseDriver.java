package core;

import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseDriver {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static ThreadLocal<CSVRecord> csvRecord = new ThreadLocal<>();

	public static void setTestData(CSVRecord cSVRecord1) {
		csvRecord.set(cSVRecord1);
	}

	public static CSVRecord getTestData() {
		return csvRecord.get();
	}

	public static void setDriver(WebDriver drivername) {
		driver.set(drivername);
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public void waitForElementToVisible(By locator, long timeout) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForElementToPresent(By locator, long timeout) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public void waitForElementToPresent(String id, long timeout) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
	}

	public void waitForElementToInvisible(By locator, long timeout) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
}
