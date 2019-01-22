package ru.pflb.tech.configuration;

public class Configuration {

    public static final Browser BROWSER = Browser.getByName(System.getProperty("browser", "firefox"));
    public static final Boolean USE_SELENIUM_GRID = Boolean.parseBoolean(System.getProperty("useSeleniumGrid", "false"
    ));
    public static final String SELENIUM_HUB_URL = System.getProperty("seleniumHubUrl", "http://localhost:4444/wd/hub");
    public static final String URL = System.getProperty("url");
    public static final String LOGIN = System.getProperty("login");
    public static final String PASSWORD = System.getProperty("password");

}