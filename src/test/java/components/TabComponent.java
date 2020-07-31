package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static core.BaseDriver.getDriver;
import java.util.List;

public class TabComponent {
    public boolean isTabDisplayed(List<String> tabList) {
        boolean tabMatched = false;
        List<WebElement> webElements = getDriver().findElements(By.xpath("/div[contains (@class, 'tab')]//a"));
        for (WebElement element : webElements) {
            String tabName = element.getText();
            tabMatched = tabList.contains(tabName);
            if (!tabMatched) {
                break;
            }
        }
        return tabMatched;
    }

    public boolean clickTab(String tabName) {
        WebElement webElement = getDriver().findElement(By.xpath(String.format("//*[contains(@class, 'container')]//*[text()='%s']", tabName)));
        webElement.click();
        return true;
    }
}

