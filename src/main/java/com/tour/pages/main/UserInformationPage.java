package com.tour.pages.main;

import com.tour.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class UserInformationPage extends AbstractComponent {

    @FindBy(xpath = "//input[@name='email']")
    private WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPassword;

    public UserInformationPage(WebDriver driver) {
        super(driver);
    }


    public void enterDetails(Map<String, String> map) {
        userName.sendKeys(map.get("userName"));
        password.sendKeys(map.get("password"));
        confirmPassword.sendKeys(map.get("confirmPassword"));
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> this.userName.isDisplayed());
    }
}
