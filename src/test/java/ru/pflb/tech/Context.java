package ru.pflb.tech;

import org.openqa.selenium.WebDriver;

public class Context {

    private WebDriver driver;
    private PageObjectManager pageObjectManager = new PageObjectManager();

    public WebDriver getDriver(){
        return driver;
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
        this.pageObjectManager.setDriver(driver);
    }

    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }
}