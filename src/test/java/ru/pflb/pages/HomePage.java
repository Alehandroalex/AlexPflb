package ru.pflb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pflb.tech.konfiguratin.Configuration;
import ru.pflb.tech.page.PageObject;

import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HomePage extends PageObject {

    public HomePage(WebDriver driver){
        super(driver);
    }

    public WebElement getToGetMail(){
        return new WebDriverWait(driver, 30).until(presenceOfElementLocated(linkText("Завести почту")));
    }

    public HomePage open(){
        driver.get(Configuration.URL);
        return this;
    }
}