package ru.pflb.pages;

import org.openqa.selenium.WebDriver;
import ru.pflb.tech.configuratin.Configuration;
import ru.pflb.tech.page.PageObject;

public class HomePage extends PageObject {

    public HomePage(WebDriver driver){
        super(driver);
    }

    public HomePage open(){
        driver.get(Configuration.URL);
        return this;
    }
}