package ru.pflb.tech.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class PageElement extends PageObject {

    protected final WebElement root;

    public PageElement(WebDriver driver, WebElement root){
        super(driver);
        this.root = root;
    }

}
