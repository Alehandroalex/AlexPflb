package ru.pflb.tech.step;

import org.openqa.selenium.WebDriver;
import ru.pflb.models.Letter;
import ru.pflb.tech.page.PageObjectManager;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private WebDriver driver;
    private PageObjectManager pageObjectManager = new PageObjectManager();
    private Map <String, Letter> letters = new HashMap<>();

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

    public Context addLetter (String alias, Letter letter){
        if(letters.containsKey(alias)){
            throw new IllegalArgumentException("Письмо с данным псевдонимом уже присутствует");
        }
        letters.put(alias, letter);
        return this;
    }

    public Letter getLetter (String alias){
        return letters.get(alias);
    }

}