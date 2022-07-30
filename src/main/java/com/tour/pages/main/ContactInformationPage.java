package com.tour.pages.main;

import com.tour.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class ContactInformationPage extends AbstractComponent {

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneNum;

    @FindBy(xpath = "//input[@name='userName']")
    private WebElement email;

    public ContactInformationPage(WebDriver driver) {
        super(driver);
    }


    public void enterDetails(Map<String, String> enterDetails) {
        firstName.sendKeys(enterDetails.get("firtName"));
        lastName.sendKeys(enterDetails.get("lastName"));
        phoneNum.sendKeys(enterDetails.get("phoneNum"));
        email.sendKeys(enterDetails.get("email"));
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> this.firstName.isDisplayed());
    }
}
