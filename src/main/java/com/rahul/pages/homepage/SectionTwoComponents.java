package com.rahul.pages.homepage;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rahul.pages.common.AbstractComponent;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SectionTwoComponents extends AbstractComponent {


    @FindBy(xpath = "//input[@placeholder='Enter Your Name']")
    WebElement inputName;

    @FindBy(xpath = "//input[@id='alertbtn']")
    WebElement alertbtn;

    @FindBy(xpath = "//button[@id='openwindow']")
    WebElement newWindow;

    @FindBy(xpath = "//h2[normalize-space()='Featured Courses']")
    WebElement feauredText;

    public SectionTwoComponents(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name){
        inputName.sendKeys(name);
    }

    public String clickAlertBtn(){
        alertbtn.click();
       Alert alert = driver.switchTo().alert();
       String val=  alert.getText();
       alert.accept();
       return val;
    }


    public void newWindowValidate(){
    String parentWindow = driver.getWindowHandle();
     newWindow.click();
     Set<String> windowList = driver.getWindowHandles();
     windowList.stream().filter(id -> !id.equals(parentWindow)).
             forEach(window -> driver.switchTo().window(window));
     Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
     System.out.println("I'm in new Window" + feauredText.getText());
     driver.switchTo().window(parentWindow);
     Assert.assertTrue(newWindow.isDisplayed());
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }


}
