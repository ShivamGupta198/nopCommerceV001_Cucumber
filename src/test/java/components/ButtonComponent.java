package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static core.BaseDriver.getDriver;

public class ButtonComponent {
    private static final String BUTTONXPATHTEXT = "//button[text() = '%s']";

    public boolean clickButton(String label) {
        List<WebElement> WebElements = getDriver().findElements(By.xpath(String.format(BUTTONXPATHTEXT, label)));
        WebElements.get(0).click();
        return !WebElements.isEmpty();
    }

    public boolean verifyButtonstatus(String buttonName) {
        return getDriver().findElement(By.xpath(String.format(BUTTONXPATHTEXT, buttonName))).isEnabled();
    }

    public boolean verifyButtonstatusById(String id) {
        return getDriver().findElement(By.id(id)).isEnabled();
    }

    public boolean verifyButtonVisibility(String buttonName) {
        boolean flag = true;
        try {
            getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
            getDriver().findElement(By.xpath(String.format(BUTTONXPATHTEXT, buttonName)));

        } catch (Exception e) {
            flag = false;
        }

        return flag;
    }
}
