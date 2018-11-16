package ru.pflb.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.pflb.tech.BaseStep;
import ru.pflb.tech.Context;

import java.util.concurrent.TimeUnit;

public class Hooks extends BaseStep {

    public Hooks(Context context){
        super(context);
    }

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", Hooks.class.getResource("../geckodriver.exe").getFile());
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        context.setDriver(driver);
    }

    @After
    public void tearDown(){
        getDriver().quit();
    }

//    @And("^wait \"([^\"]*)\" seconds$")
//    public void waitSeconds(int wait) throws Throwable{
//        TimeUnit.SECONDS.sleep(wait);
//    }

}
