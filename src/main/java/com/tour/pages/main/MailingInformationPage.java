package com.tour.pages.main;

import com.tour.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class MailingInformationPage extends AbstractComponent {

    @FindBy(xpath = "//input[@name='address1']")
    private WebElement address;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement city;

    @FindBy(xpath = "//input[@name='state']")
    private WebElement state;

    @FindBy(xpath = "//input[@name='postalCode']")
    private WebElement postalCode;

    @FindBy(xpath = "//select[@name='country']")
    private WebElement country;

    public MailingInformationPage(WebDriver driver) {
        super(driver);
    }


    public void selectCountry(String countryName){
        Select select= new Select(this.country);
        select.selectByVisibleText(countryName);
    }

    public void enterDetails(Map<String, String> enterDetails) {
        address.sendKeys(enterDetails.get("address"));
        city.sendKeys(enterDetails.get("city"));
        state.sendKeys(enterDetails.get("state"));
        postalCode.sendKeys(enterDetails.get("postalCode"));
        selectCountry(enterDetails.get("countryName"));
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> this.address.isDisplayed());
    }
}
