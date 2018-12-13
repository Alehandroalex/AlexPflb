package ru.pflb.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.PageObject;

public class RowOfLetter extends PageObject {

    public RowOfLetter(WebDriver driver){
        super(driver);
    }

    @FindBy(className = "_nb-checkbox-flag")
    public WebElement checkbox;

    public WebElement getRowLetterByTopic(String text){
        return driver.findElement(By.linkText(text));
    }

    public void clickToLetter(){
        driver.findElement(By.cssSelector("div.mail-MessageSnippet-Content")).click();
    }
}
