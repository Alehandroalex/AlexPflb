package ru.pflb.tech.configuration;

public enum Browser {

    // Неплохой выбор
    FIREFOX("firefox", "(?i)(firefox|mozilla)"),

    // В последнее время ест много оперативы
    CHROME("chrome", "(?i)(chrome|google)"),

    // Вы кто такой, если пользуетесь этим браузером?
    EDGE("edge", "(?i)(edge|microsoft edge)"),

    // Плохой выбор
    IE("iexplorer", "(?i)(ie|iexplorer|internet explorer)");

    private String name, matcher;

    Browser(String name, String matcher){
        this.name = name;
        this.matcher = matcher;
    }

    public String getName(){
        return name;
    }

    public static Browser getByName(String name){
        if(name == null)
            throw new IllegalArgumentException("Parameter 'name' can't be null");
        for(Browser browser : values()){
            if(name.matches(browser.matcher)){
                return browser;
            }
        }
        throw new RuntimeException(String.format("Can't find browser by name '%s'", name));
    }

}