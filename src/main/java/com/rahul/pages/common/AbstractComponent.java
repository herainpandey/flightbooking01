package com.rahul.pages.common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
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
        String distination = System.getProperty("user.dir")+"\\screenshots\\"+fileName;
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File(distination));
        }catch (Exception e){
            e.printStackTrace();
        }
        return distination;
    }


    public void scrollToElementJS(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("agruments[0].scrollIntoView(true);",element);
    }

    public void clickElementJS(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("agruments[0].click();",element);
    }

    public void moveToElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void scrollToElementAction(WebElement element){
        Actions action = new Actions(driver);
        action.scrollToElement(element).perform();
    }
}