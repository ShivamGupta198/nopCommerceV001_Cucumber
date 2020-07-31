package components;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import static core.BaseDriver.getDriver;


import java.util.List;

public class DropDownComponent {
    public void selectItemFromDropDown(String visibleText, String dropDownName) {
        Select grpTypeDropDown = new Select(getDriver().findElement(By.xpath(String.format("//*[text()='%s']/../following-sibling::span//select", dropDownName))));

        grpTypeDropDown.selectByVisibleText(visibleText);
    }

    public boolean isDropDownDisplayed(String dropDownName, String tableName, int rowNumber) {
        WebElement element = getDriver().findElement(By.xpath(String.format("//*[text()='%s']//ancestor::div[@id='%s']//tr[%s]//span[contains(@class,'__arrow'))", dropDownName, tableName, rowNumber)));
        return element.isDisplayed();
    }

    public WebElement getDropDownElement(String dropDownName, String tableName, int rowNumber) {
        Assert.assertTrue("Drop Down is not displayed", isDropDownDisplayed(dropDownName, tableName, rowNumber));


        return getDriver().findElement(By.xpath(String.format("//*[text()='%s']//ancestor::div[@id='%s']//tr[%s]//span[contains(@class, '__arrow'))", dropDownName, tableName, rowNumber)));
    }

    // this method for get all option dropdown in table
    public List<String> getListofoptionsFromDropDown(String dropDownName, String tableName, int rowNumber) {
        Assert.assertTrue("Drop Down is not displayed", isDropDownDisplayed(dropDownName, tableName, rowNumber));

        Select dropDownElement = new Select(getDriver().findElement(By.xpath(String.format("//*[text()='%s']//ancestor::div[@id='%s']//tr[%s]//select", dropDownName, tableName, rowNumber))));

        List<WebElement> dropDownElements = dropDownElement.getOptions();
        List<String> options = new ArrayList<>();
        for (WebElement element : dropDownElements) {
            options.add(element.getText().trim());
        }

        return options;
    }

    //this method for get All option dropdown
    public List<String> getListFromDropDown(String labelName) {
        Select dropDownElement = new Select(getDriver().findElement(By.xpath(String.format("//*[text()='%s']//select", labelName))));
        List<WebElement> dropDownElements = dropDownElement.getOptions();

        List<String> options = new ArrayList<>();

        for (WebElement element : dropDownElements) {
            options.add(element.getText().trim());
        }
        return options;
    }

    public void selectItemFromDropDownByLabel(String visibleText, String dropDownName) {
        Select grpTypeDropDown = new Select(getDriver().findElement(By.xpath(String.format("//*[text()='%s']//select", dropDownName))));
        grpTypeDropDown.selectByVisibleText(visibleText);
    }

    public void selectItemFromDropDownBYID(String visibleText, String dropdownId) {
        Select grpTypeDropDown = new Select(getDriver().findElement(By.id(dropdownId)));
        grpTypeDropDown.selectByVisibleText(visibleText);
    }

    public String getDropdownTextById(String dropdownId) {
        Select grpTypeDropDown = new Select(getDriver().findElement(By.id(dropdownId)));

        return grpTypeDropDown.getFirstSelectedOption().getText();
    }


    // this method use to verify all options form dropdown
    public List<String> verifyoptionsFromDropDown(String id) {
        Select dropDownList = new Select(getDriver().findElement(By.xpath(String.format("//select[@id='%s')", id))));
        List<String> optionText = new ArrayList<>();

        for (WebElement we : dropDownList.getOptions()) {
            optionText.add(we.getText());
        }
        return optionText;
    }

    public void selectRandomOptionFromDropDown(String id, int startIndex, int endIndex) {
        WebElement suffix = getDriver().findElement(By.id(id));

        Select select = new Select(suffix);
    //    select.selectByIndex(RandomStringGenerator.getRandomNumberInRange(startIndex, endIndex));
    }

    public void selectRandomOptionFromDropDownByxpath(String xpath) {
        WebElement suffix = getDriver().findElement(By.xpath(xpath));
        Select select = new Select(suffix);
  //      select.selectByIndex(RandomStringGenerator.getRandomNumberInRange(1, select.getOptions().size() - 1));

    }

}
