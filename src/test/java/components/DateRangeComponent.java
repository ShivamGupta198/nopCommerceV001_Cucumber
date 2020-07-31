package components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static core.BaseDriver.getDriver;

public class DateRangeComponent {

    private static final String PLACEHOLDERTEXT = "//input[@placeholder='%s']";

    public void sendKeys(String placeHolderName, String date) {
        WebElement dateRangeInputBox = getDriver().findElement(By.xpath(String.format(PLACEHOLDERTEXT, placeHolderName)));

        dateRangeInputBox.click();
        dateRangeInputBox.click();
        dateRangeInputBox.sendKeys(date + Keys.TAB);
    }

    public String getDateRangeInputText(String placeHolderName) {
        WebElement dateRangeInputBox = getDriver().findElement(By.xpath(String.format(PLACEHOLDERTEXT, placeHolderName)));
        return dateRangeInputBox.getAttribute("value");
    }

    public WebElement selectLink(String anchoreText) {
        return getDriver().findElement(By.xpath(String.format("//a[@data-handler='%s']", anchoreText)));
    }


    public WebElement getMonth() {
        return getDriver().findElement(By.xpath("//span[@class='ui-datepicker-month']"));
    }

    public WebElement getYear() {
        return getDriver().findElement(By.xpath("//span[@class='ui-datepicker-year']"));
    }

    public WebElement selectDays(String days) {
        return getDriver().findElement(By.xpath(String.format("//td[not(@class)]//a[text()='%s']", days)));
    }

    //date format should be Date month year Eg 21 septep
    public void selectDate(String dateRangeplaceHolderName, String day, String month, String year) {
        WebElement dateRangeInputBox = getDriver().findElement(By.xpath(String.format(PLACEHOLDERTEXT, dateRangeplaceHolderName)));
        dateRangeInputBox.click();
        while (!getYear().getText().equalsIgnoreCase(year)) {
            selectLink("next").click();
        }
        while (!getMonth().getText().equalsIgnoreCase(month)) {
            selectLink("next").click();
        }
        selectDays(day).click();
    }

    //date range
    public void selectPreviousDate(String dateRangeplaceholderName, String day, String month, String year) {
        WebElement dateRangeInputBox = getDriver().findElement(By.xpath(String.format(PLACEHOLDERTEXT, dateRangeplaceholderName)));
        dateRangeInputBox.click();
        while (!getYear().getText().equalsIgnoreCase(year)) {
            selectLink("prev").click();
        }
        while (!getMonth().getText().equalsIgnoreCase(month)) {
            selectLink("prev").click();
        }
        selectDays(day).click();
    }

    public String subtractedDays(String date, int days) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date formattedDate = formatter.parse(date);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(formattedDate);
        cal.add(Calendar.DATE, -days);
        SimpleDateFormat newFormat = new SimpleDateFormat("MM/dd/yyyy");
        newFormat.setCalendar(cal);
        String result = newFormat.format(cal.getTime());
        return result;

    }
}
