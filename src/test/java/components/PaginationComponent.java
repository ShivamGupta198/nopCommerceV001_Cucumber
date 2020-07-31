package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static core.BaseDriver.getDriver;

public class PaginationComponent {

    public boolean clickNextPage() {
        WebElement page = getDriver().findElement(By.xpath("//a[contains(@class, 'current')]//following::a[1]"));
        page.click();
        return page.isEnabled();
    }

    public boolean clickPageByNumber(int pageNumber) {
        WebElement page = getDriver().findElement(By.xpath(String.format("///*[contains(@class, 'paginate')]//a[%d]", pageNumber)));
        page.click();
        return page.isEnabled();
    }

    public boolean clickPaginationNextButton() {
        WebElement page = getDriver().findElement(By.xpath("//a[contains(@title, 'Next page'))"));
        if (page.isEnabled())
            page.click();
        return page.isEnabled();
    }

    public boolean clickPaginationPreviousButton() {
        WebElement page = getDriver().findElement(By.xpath("//a[contains(@title, 'Previous page'))"));
        if (page.isEnabled())
            page.click();
        return page.isEnabled();
    }

    public void selectItemFromDropDownPagination(String visibleText) {
        Select grpTypeDropDown = new Select(getDriver().findElement(By.xpath("//span[@class='select2-selection__rendered']/ancestor::span/select")));
        grpTypeDropDown.selectByVisibleText(visibleText);
    }

    public int calculateNumberofPages() {
        return getDriver().findElements(By.xpath("//a[@aria-controls='table_gen_feeFcTable']")).size();

    }
}
