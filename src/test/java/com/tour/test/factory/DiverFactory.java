package com.tour.test.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DiverFactory {
    private static final Supplier<WebDriver> CHROME =  () -> new ChromeDriver();
    private static final Supplier<WebDriver>  FIREFOX =  () -> new FirefoxDriver();
    private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();

    static{
        MAP.put("chrome",CHROME);
        MAP.put("firefox",FIREFOX);
    }

    public static WebDriver getDriver(String browser){
        return MAP.get(browser).get();
    }
}
