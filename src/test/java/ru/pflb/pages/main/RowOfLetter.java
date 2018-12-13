package ru.pflb.pages.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RowOfLetter {

    private final WebDriver driver;
    private final WebElement root;

    @FindBy(className = "_nb-checkbox-flag")
    public WebElement checkbox;

    public RowOfLetter(WebDriver driver, WebElement root){
        this.driver = driver;
        this.root = root;
    }

    public void open(){
        root.click();
    }
}
