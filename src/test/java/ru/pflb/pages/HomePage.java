package ru.pflb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.PageObject;

public class HomePage extends PageObject {

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(linkText = "Завести почту")
    public WebElement toGetMail;
}