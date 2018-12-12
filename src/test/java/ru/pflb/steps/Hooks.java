package ru.pflb.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.pflb.tech.BaseStep;
import ru.pflb.tech.Context;

import java.util.concurrent.TimeUnit;

public class Hooks extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);

    public Hooks(Context context){
        super(context);
        LOGGER.debug("Hooks is created");
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