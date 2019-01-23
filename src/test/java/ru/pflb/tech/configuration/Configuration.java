package ru.pflb.tech.configuration;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    private static final Map<Thread, Browser> browserMap = new HashMap<>();

    public static final Boolean USE_SELENIUM_GRID = Boolean.parseBoolean(System.getProperty("useSeleniumGrid", "false"
    ));
    public static final String SELENIUM_HUB_URL = System.getProperty("seleniumHubUrl", "http://localhost:4444/wd/hub");
    public static final String URL = System.getProperty("url");
    public static final String LOGIN = System.getProperty("login");
    public static final String PASSWORD = System.getProperty("password");

    public static void setBrowser(String browser){
        setBrowser(Browser.getByName(browser));
    }

    public static void setBrowser(Browser browser){
        browserMap.put(Thread.currentThread(), browser);
    }

    public static Browser getBrowser(){
        Thread thread = Thread.currentThread();
        if(! browserMap.containsKey(thread)){
            setBrowser(System.getProperty("browser", "firefox"));
        }
        return browserMap.get(thread);
    }

}