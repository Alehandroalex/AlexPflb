package ru.pflb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pflb.tech.page.PageObject;

public class CommonPage extends PageObject {

    public CommonPage(WebDriver driver){
        super(driver);
    }

    public WebElement getElementWithText(String text){
        return (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//*[contains(text(), '%s')]", text))));
    }

}
