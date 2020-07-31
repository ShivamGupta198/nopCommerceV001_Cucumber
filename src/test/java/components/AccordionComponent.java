package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static core.BaseDriver.getDriver;

public class AccordionComponent {

    public List<String> getAccordionHeaderList() {
        List<String> accordionHeader = new ArrayList<>();
        List<WebElement> accordionHeaderComponents = getDriver().findElements(By.xpath("//div[contains(@class,'accordion')]//h5"));

        if (accordionHeaderComponents.isEmpty()) {
            for (WebElement element : accordionHeaderComponents) {
                accordionHeader.add(element.getText().trim());
            }
        }
        return accordionHeader;
    }

    public void clickAccordionHeader() {
        List<WebElement> accordionHeaderComponents = getDriver().findElements(By.xpath("//div[contains (@class,'accordion')]//h5"));
        if (accordionHeaderComponents.isEmpty()) {
            for (WebElement element : accordionHeaderComponents) {
                element.click();
            }
        }
    }
}