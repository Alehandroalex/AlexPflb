package ru.pflb.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.pflb.tech.configuration.Configuration;
import ru.pflb.tech.step.BaseStep;
import ru.pflb.tech.step.Context;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static ru.pflb.tech.configuration.Configuration.BROWSER;
import static ru.pflb.tech.configuration.Configuration.SELENIUM_HUB_URL;

public class Hooks extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);

    public Hooks(Context context){
        super(context);
        LOGGER.debug("Hooks is created");
    }

    @Before
    public void setUp() throws MalformedURLException{
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "selenium_log.log");
        WebDriver driver;

        if(Configuration.USE_SELENIUM_GRID){
            URL seleniumHubUrl = new URL(SELENIUM_HUB_URL);
            Capabilities capabilities;
            switch(BROWSER){
                case CHROME:
                    capabilities = new ChromeOptions();
                    break;
                case FIREFOX:
                    capabilities = new FirefoxOptions();
                    break;
                case EDGE:
                    capabilities = new EdgeOptions();
                    break;
                case IE:
                    capabilities = new InternetExplorerOptions();
                    break;
                default:
                    throw new RuntimeException("Browser is undefined");
            }
            driver = new RemoteWebDriver(seleniumHubUrl, capabilities);
        } else{
            switch(BROWSER){
                case CHROME:
                    System.setProperty("webdriver.chrome.driver",
                            Hooks.class.getResource("../chromedriver.exe").getFile());
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver",
                            Hooks.class.getResource("../geckodriver.exe").getFile());
                    driver = new FirefoxDriver();
                    break;
                case EDGE:
                    System.setProperty("webdriver.edge.driver",
                            Hooks.class.getResource("../MicrosoftWebDriver.exe").getFile());
                    driver = new EdgeDriver();
                    break;
                case IE:
                    System.setProperty("webdriver.ie.driver",
                            Hooks.class.getResource("../IEDriverServer.exe").getFile());
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    throw new RuntimeException("Browser is undefined");
            }
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        context.setDriver(driver);
    }

    @After
    public void tearDown(){
        getDriver().quit();
    }

}