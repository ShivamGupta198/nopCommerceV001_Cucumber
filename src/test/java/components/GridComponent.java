package components;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static core.BaseDriver.getDriver;

public class GridComponent {

    private static final String XPATHFORCOLUMN = "//tbody//tr/td[count (//table/thead/tr/th[.='%s']/preceding-sibling::th)+1]";

    public int getTableRowCount(String tableName) {
        List<WebElement> element = getDriver().findElements(By.xpath("//table//tbody//tr"));
        return element.size();
    }

    public int getTableRowCount() {
        List<WebElement> element = getDriver().findElements(By.xpath("//table//tbody//tr"));
        return element.size();
    }

    public boolean verifyTableHeader(List<String> expectedTableHeaderNames, String tableName) {
        List<WebElement> uiTableHeaderNames;

        if (tableName.equals(""))
            uiTableHeaderNames = getDriver().findElements(By.xpath("//table//thead//tr/th"));
        else
            uiTableHeaderNames = getDriver().findElements(By.xpath(String.format("//h5[text()='%s']//following::table[1]//thead//tr/th", tableName)));


        List<String> uiTableHeaderNamesText = new ArrayList<>();
        uiTableHeaderNames.stream().forEach(e -> uiTableHeaderNamesText.add(e.getText()));

        for (String headerName : expectedTableHeaderNames) {
            if (!uiTableHeaderNamesText.contains(headerName)) {
                return false;
            }
        }

        return true;
    }

    public List<String> getColValuesFromTab(String tabName, String colHeaderName) {
        List<String> arrList = new ArrayList<>();

        List<WebElement> columnElements = getDriver().findElements(By.xpath(String.format("//div[contains (@class,'tab')]//a[text()='%s']//ancestor::div[contains(@class, 'grid')]//tbody//tr/td[count(//table/thead/tr/th[.='%s']/preceding-sibling: :th)+1)", tabName, colHeaderName)));

        for (WebElement column : columnElements) {
            arrList.add(column.getText().trim());
        }
        return arrList;
    }

    public List<String> getColValues(String colHeaderName) {
        List<String> arrlist = new ArrayList<>();
        List<WebElement> columnElements = getDriver().findElements(By.xpath(String.format(XPATHFORCOLUMN, colHeaderName)));
        for (WebElement column : columnElements) {
            arrlist.add(column.getText().trim());
        }

        return arrlist;
    }

    public boolean getCheckBoxById(int rowNumber, int colNumber, String idName) {
        return getDriver().findElement(By.xpath(String.format("//table/tbody/tr['%s']/td['%s']/div/input[@id='%s')", rowNumber, colNumber, idName))).isEnabled();
    }

    public WebElement getCheckBoxOnGrid(String tableName, int rowNumber, int colNumber) {
        return getDriver().findElement(By.xpath(String.format("//div[@id='%s']//ancestor::div[@class='container']//tr[%s]//td[%s]//label", tableName, rowNumber, colNumber)));
    }

    public WebElement getSelectAllCheckBoxGrid(String tableName) {
        return getDriver().findElement(By.xpath(String.format("//div[@id='%s']//ancestor::div[@class='container']//thead//label", tableName)));
    }

    public WebElement getCheckBoxWithInput(String tableName, int rowNumber, int colNumber) {
        return getDriver().findElement(By.xpath(String.format("//div[@id='%s']//ancestor::div[@class='container']//tr[%s]//td[%s]//input", tableName, rowNumber, colNumber)));
    }

    public WebElement getValueOnGrid(String tableName, int rowNumber, int colNumber) {
        return getDriver().findElement(By.xpath(String.format("//div[@id='%s']//ancestor::div[@class='container']//tr[%s]//td[%s]", tableName, rowNumber, colNumber)));
    }

    public WebElement getButtonValueOnGrid(String labelName, int rowNumber) {
        return getDriver().findElement(By.xpath(String.format("//div//following::button[text()='%s'][%s]", labelName, rowNumber)));
    }

    public WebElement getGridByParentLabel(String label, String value) {
        return getDriver().findElement(By.xpath(String.format("//%s[text()='%s']//following::table", label, value)));
    }

    public List<WebElement> getGridValuesByColumnName(int columnNumber) {
        return getDriver().findElements(By.xpath(String.format("//table//tr//td[%d]", columnNumber)));
    }

    public void clickDownArrowFromGrid(String tableName, int rownumber, int colNumber) {
        String tableAttribute = getDriver().findElement(By.xpath(String.format("//div[@id='%s']//tbody/tr", tableName))).getAttribute("class");
        if (tableAttribute.equals("odd")) {
            WebElement element = getDriver().findElement(By.xpath(String.format("//div[@id='%s']//tbody/tr[%s]/td[%s]", tableName, rownumber, colNumber)));
            element.click();
        }
    }

    public void clickUpArrowFromGrid(String tableName, int rowNumber, int colNumber) {
        String tableAttribute = getDriver().findElement(By.xpath(String.format("//div[@id='%s']//tbody/tr", tableName))).getAttribute("class");
        if (tableAttribute.trim().contains("parent")) {
            WebElement element = getDriver().findElement(By.xpath(String.format("//div[@id='%s']//tbody/tr[%s]/td[%s]", tableName, rowNumber, colNumber)));
            element.click();
        }
    }

    public void verifyTableHeaderInsideAnotherTable(List<String> tableHeaderNames, int tableIndex) {
        List<WebElement> tableHeaderName;
        String message = "Actual:::'%s', Expected:::'%s'";
        tableHeaderName = getDriver().findElements(By.xpath("//tr//table['" + tableIndex + "]//th"));
        for (WebElement headerName : tableHeaderName) {
            if (!headerName.getText().equals("")) {
                Assert.assertNotEquals(String.format(message, tableHeaderNames.get(tableHeaderNames.indexOf(headerName.getText().trim())),
                        headerName.getText()), -1, tableHeaderNames.indexOf(headerName.getText().trim()));
            }
        }
    }

    //  To get the value of cell present in web table * @param rowNumber * @param colNumber * @return
    public String getcellvalue(int rowNumber, int colNumber, String... tablename) {
        if (tablename.length > 0) {
            return getDriver().findElement(By.xpath(String.format("//*[@id='%s']//tr[%s]/td[%s]", tablename[0], rowNumber, colNumber))).getText().trim();
        }
        return getDriver().findElement(By.xpath(String.format("//tbody/tr[%s]/td[%s]", rowNumber, colNumber))).getText().trim();
    }

    // To verify if element is not present inside the cell * @param rowNumber  @param colNumber @elementText

    public void verifyElementNotFoundOncell(int rowNumber, int colNumber, String elementText) {
        boolean elementFound = false;
        try {
            getDriver().findElement(By.xpath(String.format("//tbody/tr[%s]/td[%s]//label(text()='%s']", rowNumber, colNumber, elementText))).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            elementFound = true;
        }

        Assert.assertTrue(elementFound);
    }

    // To verify if DropDown is not present inside the cell * @param rowNumber * @param colNumber
    public void verifyDropDownNotFoundOncell(int rowNumber, int colNumber) {
        boolean elementNotFound = false;
        try {
            getDriver().findElement(By.xpath(String.format("//tbody/tr[%s]/td[%s]//select", rowNumber, colNumber))).isDisplayed();
        } catch (NoSuchElementException e) {
            elementNotFound = true;
        }
        Assert.assertTrue(elementNotFound);
    }

    //To Click on Element using text inside webtable @param rowNumber *@param colNumber *@param element Text

    public void clickElementInWebTable(int rowNumber, int colNumber, String elementText) {
        getDriver().findElement(By.xpath(String.format("//tbody/tr[%s]/td[%s]//*[text()='%s']", rowNumber, colNumber, elementText))).click();
    }
    //To select the value from drop down present inside web table * @param rowNumbers @param SolNumber *@param visibleText

    public void selectValueFromDropdown(int rowNumber, int colNumber, String visibleText) {
        new Select(getDriver().findElement(By.xpath(String.format("//tbody/tr [%s]/td[%s]//select", rowNumber, colNumber)))).selectByVisibleText(visibleText);
    }

    public void clickColumnForSorting(String colHeading) {
        WebElement tableHeadercolumnElement = getDriver().findElement(By.xpath(String.format("//*[@class='sorting' and text='%s']", colHeading)));
        tableHeadercolumnElement.click();
    }

    public String getColumnSortedType(String colHeading) {
        WebElement element = getDriver().findElement(By.xpath(String.format("//*[@class='sorting_asc' and text()= '%s')", colHeading)));
        return element.getAttribute("aria-sort");
    }

    public List<String> getColValues(String tableName, String colHeaderName) {
        List<String> arrList = new ArrayList<>();
        List<WebElement> columnElements = null;
        if (tableName.equals("")) {
            columnElements = getDriver().findElements(By.xpath(String.format(XPATHFORCOLUMN, colHeaderName)));
        } else {
            columnElements = getDriver().findElements(By.xpath(String.format("//table[@id='%s']//tbody//tr/td[count(//table/thead/tr/th[.='%s']/preceding-sibling::th)+1]", tableName, colHeaderName)));
        }
        for (WebElement column : columnElements) {
            arrList.add(column.getText().trim());
        }
        return arrList;
    }

    public List<WebElement> getGridvaluesByColumnNumber(int columnNumber) {
        return getDriver().findElements(By.xpath(String.format("//*[@id=\"table_gen_23\"]//tr//td[%s]", columnNumber)));
    }

    public boolean verifyElementpresentByClass(String className) {
        return getDriver().findElement(By.xpath(String.format("//*[@class='%s']", className))).isDisplayed();
    }

    public WebElement getExpandAndcollapseInGrid(int tablerowNumber) {
        return getDriver().findElement(By.xpath(String.format("//table//tbody//tr[%s]//td[@aria-label='Expand row']", tablerowNumber)));
    }

    public int getTableRowCountByxpath(String xpath) {
        return getDriver().findElements(By.xpath(xpath)).size();
    }

    public String getTableValueByxpath(String xpath) {
        return getDriver().findElements(By.xpath(xpath)).get(0).getText();
    }

    public List<WebElement> getColElements(String colHeaderName) {
        return getDriver().findElements(By.xpath(String.format(XPATHFORCOLUMN, colHeaderName)));
    }

    public void clickButtonInWebTable(int rowNumber, int colNumber, int buttonNumber) {
        getDriver().findElement(By.xpath(String.format("//tbody/tr[%s]/td[%s]/button[%s]", rowNumber, colNumber, buttonNumber))).click();
    }
}
