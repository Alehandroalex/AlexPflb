package ru.pflb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pflb.PageObject;

public class HomePage extends PageObject {

    public HomePage(WebDriver driver){
        super(driver);
    }

//    @FindBy(linkText = "Завести почту")
//    public WebElement toGetMail;

    public WebElement getToGetMail(){
        return (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Завести почту")));
    }
}