package com.rahul.test;


import com.rahul.test.factory.DiverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;


public class BaseTest {

    protected WebDriver driver;
    private ThreadLocal<WebDriver> thread = new ThreadLocal<>();

    @Parameters({"browser"})
    @BeforeTest
    public void setBrowserInstance(String browser) throws MalformedURLException {

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\chromedriver.exe");
                thread.set(DiverFactory.getDriver(browser));
                driver = thread.get();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\geckodriver.exe");
                thread.set(DiverFactory.getDriver(browser));
                driver = thread.get();
                break;
        }
    }


    @AfterTest
    public void closeBrower() {
        thread.get().quit();
        thread.remove();
    }
}
