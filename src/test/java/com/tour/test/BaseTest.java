package com.tour.test;


import com.tour.test.factory.DiverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {

    protected  WebDriver driver;

    @Parameters({"browser"})
    @BeforeTest
    public void setBrowserInstance(String browser) throws MalformedURLException {

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\chromedriver.exe");
                this.driver = DiverFactory.getDriver(browser);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\geckodriver.exe");
                this.driver = DiverFactory.getDriver(browser);
                break;
        }

         /*   String host="localhost";
        MutableCapabilities dc;

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = new FirefoxOptions();
        }else{
            dc = new ChromeOptions();
        }

        if(System.getProperty("HUB_HOST")!=null){
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl = "http://"+host+":4444/wd/hub";
        System.out.println(completeUrl);
        driver = new RemoteWebDriver(new URL(completeUrl),dc);*/
    }


    @AfterTest
    public void closeBrower(){
        this.driver.quit();
    }
}
