package ru.pflb.tech;

import org.openqa.selenium.WebDriver;

public abstract class BaseStep {

    protected final Context context;

    public BaseStep(Context context){
        this.context = context;
    }

    public WebDriver getDriver(){
        return this.context.getDriver();
    }

}
