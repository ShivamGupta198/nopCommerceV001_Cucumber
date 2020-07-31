

package utils;

import core.BaseDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static core.BaseDriver.getDriver;

public class BrowserUtility extends BaseDriver {
    public String getCssValue(String cssValue, WebElement element) {
        return element.getCssValue(cssValue);
    }

    public String getAttributeValue(String attributeValue, WebElement element) {
        return element.getCssValue(attributeValue);
    }

    public void rightClick(WebElement element) {
        try {
            Actions action = new Actions(getDriver()).contextClick(element);

            action.build().perform();
        } catch (StaleElementReferenceException e) {
            System.out.println("element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("element" + element + " was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("element " + element + " was not clickable " + e.getStackTrace());
        }
    }


    public void doubleclick(WebElement element) {
        try {
            Actions action = new Actions(getDriver()).doubleClick(element);
            action.build().perform();
        } catch (StaleElementReferenceException e) {
            System.out.println("element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("element" + element + " was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("element " + element + " was not clickable " + e.getStackTrace());
        }
    }

    public void dragAndDrop(WebElement sourceElement, WebElement destinationElement) {
        Actions action = new Actions(getDriver());
        action.dragAndDrop(sourceElement, destinationElement).build().perform();

    }

    public static void clickUsingJavascript(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
    }

    public static boolean iselementpresent(WebElement element) {
        boolean flag = false;
        try {
            if (element.isDisplayed()
                    || element.isEnabled())
                flag = true;
        } catch (NoSuchElementException | StaleElementReferenceException e) {

        }
        return flag;
    }

    public static String getMainWindowHandle() {
        return getDriver().getWindowHandle();
    }

    public static String getCurrentWindowTitle() {
        return getDriver().getTitle();
    }

    public static boolean closeAllOtherWindows(String openwindowHandle) {
        Set<String> allWindowHandles = getDriver().getWindowHandles();
        for (String currentwindowHandle : allWindowHandles) {
            if (!currentwindowHandle.equals(openwindowHandle)) {
                getDriver().switchTo().window(currentwindowHandle);
                getDriver().close();
            }
        }

        getDriver().switchTo().window(openwindowHandle);
        return (getDriver().getWindowHandles().size() == 1);
    }

    public static void scrollToBottom() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollto(0, document.body.scrollHeight");
    }

    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(); ", element);
    }

    public static void selectOptionInDropDownByVisibleText(WebElement element, String visibleTextOptionToSelect) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(visibleTextOptionToSelect);

        } catch (NoSuchElementException e) {
            System.out.println("option value not find in dropdown");
        }
    }

    public static void waitForNewWindowAndSwitchToIt() throws InterruptedException {
        String cHandle = getDriver().getWindowHandle();
        String newWindowHandle = null;
        Set<String> allWindowHandles = getDriver().getWindowHandles();
        //wait for 20 seconds for the new window and throw exception if not found
        for (int i = 0; i < 20; i++) {
            if (allWindowHandles.size() > 1) {
                for (String allHandlers : allWindowHandles) {
                    if (!allHandlers.equals(cHandle))
                        newWindowHandle = allHandlers;
                }
                getDriver().switchTo().window(newWindowHandle);
                break;
            } else {
                Thread.sleep(1000);
            }
        }

        if (newWindowHandle.equalsIgnoreCase(newWindowHandle)) {
            throw new RuntimeException("Time out – No window found");
        }
    }

    public void getscreenshot() throws Exception {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
        FileUtils.copyFile(srcFile, new File("D:\\screenshot.png"));
    }

    public static void moveToElementUsingLinkText(String linkText) {
        Actions action = new Actions(getDriver());
        action.moveToElement(getDriver().findElement(By.linkText(linkText))).build().perform();

    }
}

