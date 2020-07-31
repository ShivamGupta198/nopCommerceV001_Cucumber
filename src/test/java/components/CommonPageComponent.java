package components;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

import static core.BaseDriver.getDriver;

public class CommonPageComponent {
    public boolean isElementExist(String tag, String value) {

        List<WebElement> elements = getDriver().findElements(By.xpath(String.format("//%s[text()=\"%s\"]", tag, value)));
        return !elements.isEmpty();
    }

    public boolean isElementExist(String value) {

        List<WebElement> elements = getDriver().findElements(By.xpath(String.format("//*[text()=\"%s\"]", value)));
        return !elements.isEmpty();
    }

    public void clickOnRadioButton(String labelName) {
        getDriver().findElement(By.xpath(String.format("//label[text()='%s']", labelName))).click();
    }

    public boolean verifyTextBoxStatus(String textBoxName) {
        return getDriver().findElement(By.xpath(String.format("//*[text()='%s']//input", textBoxName))).isEnabled();
    }

    public boolean verifyLinkStatus(String linkText) {
        return getDriver().findElement(By.linkText(linkText)).isEnabled();
    }

    public boolean clickLinkByLinkText(String linkText) {
        try {
            getDriver().findElement(By.linkText(linkText)).click();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean verifyLinkPresent(String linkText) {
        try {
            getDriver().findElement(By.linkText(linkText));
            return true;
        } catch (
                NoSuchElementException e) {
            return false;
        }
    }

    public boolean elementNotFoundWithText(List<String> element) {

        boolean elementFlag = false;
        for (String ele : element) {
            try {
                getDriver().findElement(By.xpath(String.format("//*[text()='%s']", ele)));
                elementFlag = false;
            } catch (NoSuchElementException e) {
                elementFlag = true;
            }
        }
        return elementFlag;
    }

    public boolean elementNotFoundWithText(String element) {
        boolean elementFlag = false;
        try {
            getDriver().findElement(By.xpath(String.format("//*[text()='%s']", element)));
            elementFlag = false;
        } catch (NoSuchElementException e) {
            elementFlag = true;
        }
        return elementFlag;
    }

    public String getTextByxpath(String xpath) {
        return getDriver().findElement(By.xpath(xpath)).getText().trim();
    }

    public void entertextusingplaceholder(String placeHolderText, String textValue) {
        getDriver().findElement(By.xpath(String.format("//*[@placeholder='%s']", placeHolderText))).sendKeys(textValue);
    }

    public boolean elementNotFoundwithId(String elementid) {
        boolean elementFlag = false;
        try {
            getDriver().findElement(By.id(elementid));
            elementFlag = false;
        } catch (NoSuchElementException e) {
            elementFlag = true;
        }
        return elementFlag;
    }


    public void entertextById(String elementId, String text) {
        getDriver().findElement(By.id(elementId)).clear();
        getDriver().findElement(By.id(elementId)).sendKeys(text);

    }

    public boolean clickById(String id) {
        try {
            getDriver().findElement(By.id(id)).click();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean clickElementByClass(String className) {
        try {
            getDriver().findElement(By.className(className)).click();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresentByXpath(String xpath) {
        try {
            getDriver().findElement(By.xpath(xpath)).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getTextByClass(String className) {
        return getDriver().findElement(By.className(className)).getText();
    }

    public String getPropertybyXpath(String xpath, String attribute) {
        return getDriver().findElement(By.xpath(xpath)).getAttribute(attribute);
    }

    public int findNumberOfElementsByXpath(String xpath) {
        return getDriver().findElements(By.xpath(xpath)).size();
    }

    public boolean javaScriptClick(String text, int index) {
        try {
            WebElement element = getDriver().findElement(By.xpath(String.format("(// [text()='%s'])[%s]", text, index)));
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].click();", element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean verifyCheckBoxSelected(String xpath) {
        try {
            WebElement checkBoxElm = getDriver().findElement(By.xpath(xpath));
            return checkBoxElm.isSelected();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getTextByPlaceHolder(String placeholdertText) {
        return getDriver().findElement(By.xpath(String.format("//* [@placeholder='%s']", placeholdertText))).getAttribute("placeholder");
    }

    public void tabFromTextbox(String elemenId) {
        getDriver().findElement(By.id(elemenId)).sendKeys(Keys.TAB);
    }

    public String getTextById(String id) {
        return getDriver().findElement(By.id(id)).getText().trim();
    }

    public String getPropertyById(String id, String attribute) {
        return getDriver().findElement(By.id(id)).getAttribute(attribute);
    }

    public boolean isPageContainsText(String tag, String text) {
        return getDriver().findElement(By.xpath(String.format("//%s[contains(text(), '%s'))", tag, text))).isDisplayed();
    }

    public List<String> findnumofElementsById(String tag, String id) {
        List<WebElement> elements = getDriver().findElements(By.xpath(String.format("//%s[contains(@id,'%s'))", tag, id)));
        List<String> suffixList = new ArrayList<>();
        for (WebElement element : elements) {
            suffixList.add(element.getText());
        }

        return suffixList;
    }

    public void pageRefresh() {
        getDriver().navigate().refresh();
    }

    public WebElement getElementByXpath(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    public List<WebElement> getElementsByxpath(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }
    public WebElement getElementByHrefAndClass(String href, String className) {

        return getDriver().findElement(By.xpath(String.format("//*[@href='%s' and @class='%s']", href, className)));
    }


}




