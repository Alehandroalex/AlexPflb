package ru.pflb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {

    protected WebDriver driver;

    public PageObject(){
    }

    public PageObject(WebDriver driver){
        setDriver(driver);
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
