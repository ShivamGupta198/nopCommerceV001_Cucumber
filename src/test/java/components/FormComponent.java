package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Arrays;
import java.util.List;
import static core.BaseDriver.getDriver;

public class FormComponent {
    private String textField = "//*[text()='%s']//following::input[@type='text'][1]";
    private String datePicker = "//select[@class ='ui-datepicker-%s']";
    private String textFieldsByPlaceHolder = "//input[(@placeholder= %s']";

    public WebElement getTextfieldByLabel(String labelName) {
        return getDriver().findElement(By.xpath(String.format(textField, labelName)));
    }

    //if text box does not have label then this method will help
    public WebElement getTextFieldByPlaceHolder(String textBoxPlaceHolderName) {
        return getDriver().findElement(By.xpath(String.format(textFieldsByPlaceHolder, textBoxPlaceHolderName)));
    }

    public WebElement getTextBoxById(String textboxId) {

        return getDriver().findElement(By.id(textboxId));
    }

    public void selectDateByLabel(String labelName, String month, String day, String year) {
        List<String> fullDate = Arrays.asList(month, year);
        getDriver().findElement(By.xpath(String.format(textField, labelName))).click();
        int counter = 0;
        for (String date : Arrays.asList("month", "year")) {
            getDriver().findElement(By.xpath(String.format(datePicker, date))).click();
            getDriver().findElement(By.xpath(String.format("//option[text()='%s']", fullDate.get(counter))));
            counter++;
        }
        getDriver().findElement(By.xpath(String.format("//table//tr//td//a[text()='%s']", day))).click();
    }
}
