package com.tour.pages.billingAddress;

import com.tour.pages.common.AbstractComponent;
import com.tour.pages.orderDetail.FlightSummary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class BillingAddress extends AbstractComponent {

    @FindBy(xpath = "//input[@id='input_53_addr_line']")
    private WebElement addressl1;

    @FindBy(xpath = "//input[@id='input_53_addr_line2']")
    private WebElement addressl2;

    @FindBy(xpath = "//input[@id='input_53_city']")
    private WebElement city;

    @FindBy(xpath = "//input[@id='input_53_state']")
    private WebElement state;

    @FindBy(xpath = "//input[@id='input_53_postal']")
    private WebElement postal;

    @FindBy(xpath = "//input[@name='buyFlights']")
    private WebElement submitAddress;

    private FlightSummary flightSummary;

    public BillingAddress(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    public void enterBillingAddress(Map<String,String> values){
        addressl1.sendKeys(values.get("addressl1"));
        addressl2.sendKeys(values.get("addressl2"));
        city.sendKeys(values.get("city"));
        state.sendKeys(values.get("state"));
        postal.sendKeys(values.get("postal"));

    }

    public FlightSummary submitAddress(){
        submitAddress.click();
        flightSummary = PageFactory.initElements(driver,FlightSummary.class);
        return flightSummary;
    }
}
