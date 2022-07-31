package com.tour.test;


import com.tour.test.factory.DiverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;


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
