package ru.pflb.pages.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.tech.page.PageElement;

import java.util.ArrayList;
import java.util.List;

public class RowOfLetter extends PageElement {

    public RowOfLetter(WebDriver driver, WebElement root){
        super(driver, root);
    }


    @FindBy(className = "_nb-checkbox-flag")
    public WebElement checkbox;

    public void open(){
        root.click();
    }

    public String getBody(){
        return root.findElement(By.className("js-message-snippet-firstline")).getText();
    }

    public boolean hasRecipient(String recipient){
        return root.findElements(By.cssSelector(String.format("span[title='%s']", recipient))).size() > 0;
    }

    public List<String> getRecipients(){
        List<WebElement> recipientElements = root.findElements(By.cssSelector("span.js-message-snippet-sender > span"));
        List<String> recipients = new ArrayList<>(recipientElements.size());
        for(WebElement recipientElement : recipientElements){
            recipients.add(recipientElement.getAttribute("title"));
        }
        return recipients;
    }

    public WebElement getCheckBox(){
        return root.findElement(By.className("_nb-checkbox-flag"));
    }

    public void checkBoxClick(){
        getCheckBox().click();
    }

}