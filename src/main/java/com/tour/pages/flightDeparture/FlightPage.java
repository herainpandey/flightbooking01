package com.tour.pages.flightDeparture;

import com.tour.pages.billingAddress.BillingAddress;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightPage {

    private FlightDepartureComponent flightDepartureComponent;
    private FlightReturnComponent flightReturnComponent;
    private BillingAddress billingAddress;
    private WebDriver driver;

    @FindBy(xpath = "//input[@id='reserveFlights']")
    private WebElement continueBtn;

    public FlightPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver,this);
    flightDepartureComponent = PageFactory.initElements(driver,FlightDepartureComponent.class);
    flightReturnComponent = PageFactory.initElements(driver,FlightReturnComponent.class);
    }

    public FlightDepartureComponent getFlightDepartureComponent() {
        return flightDepartureComponent;
    }

    public FlightReturnComponent getFlightReturnComponent() {
        return flightReturnComponent;
    }

    public BillingAddress clickContinue(){
        this.continueBtn.click();
        billingAddress = PageFactory.initElements(driver,BillingAddress.class);
        return billingAddress;
    }
}
