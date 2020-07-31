package components;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static core.BaseDriver.getDriver;


public class SearchContainer {

    public void clickOnMultiSelectDropDownAndSelectsValue(String dropdownName, String textToSearch, String textToSelect) {
        String elementID = null;
        if (dropdownName.isEmpty())
                elementID = getDriver().findElement(By.xpath("//select")).getAttribute("aria-labelledby");
        else
        elementID = getDriver().findElement(By.xpath(String.format("//span[text()='%s']/parent::label", dropdownName))).getAttribute("id");
        getDriver().findElement(By.xpath(String.format("//span[@aria-labelledby='%s']", elementID))).click();
        getDriver().findElement(By.xpath(String.format("//input[@aria-labelledby='%s')", elementID))).sendKeys (textToSearch);
        getDriver().findElement(By.xpath(String.format("//ul[@aria-labelledby='%s']//li[text()='%s']", elementID, textToSearch))).click();
    }
        public void deleteOptionsFromMultipDropdownBox(String countryName) {
            WebElement optionDeleteIcon = getDriver().findElement(By.xpath(String.format("//li[text()='%s' and contains(@class, 'selection_choice')]//span", countryName)));
            optionDeleteIcon.click();
        }
            public static boolean verifyTextDisplayed(String countryName) {
                WebElement textElement = getDriver().findElement (By.xpath(String.format("//li[text()='%s' and contains(@class, 'selection_choice'))", countryName)));
                return textElement.isDisplayed();
            }
        }
