package com.tour.pages.common;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public abstract  class AbstractComponent {
    protected static WebDriverWait wait;
    protected static WebDriver driver;

    public AbstractComponent(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public abstract boolean isDisplayed();

    public static String screenShotPath(String failMethod) throws IOException {
        File fileName = new File( failMethod + new Date().getTime() +".png");
        String distination = fileName.getAbsolutePath();
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File(distination));
        }catch (Exception e){
            e.printStackTrace();
        }
        return distination;
    }
}
