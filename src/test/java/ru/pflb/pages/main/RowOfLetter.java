package ru.pflb.pages.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.tech.page.PageElement;

public class RowOfLetter extends PageElement {

    public RowOfLetter(WebDriver driver, WebElement root){
        super(driver, root);
    }

    @FindBy(className = "_nb-checkbox-flag")
    public WebElement checkbox;

    public void open(){
        root.click();
    }

}
