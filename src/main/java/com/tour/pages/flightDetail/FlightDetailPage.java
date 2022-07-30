package com.tour.pages.flightDetail;

import com.tour.pages.flightDeparture.FlightPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightDetailPage {

    private FlightDetailComponent flightDetailComponent;
    private PreferenceComponent preferenceComponent;
    private WebDriver driver;
    private FlightPage flightPage;

    @FindBy(xpath = "//input[@name='findFlights']")
    private WebElement continueBtn;

    public FlightDetailPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        flightDetailComponent = PageFactory.initElements(driver,FlightDetailComponent.class);
        preferenceComponent = PageFactory.initElements(driver,PreferenceComponent.class);
    }

    public FlightDetailComponent getFlightDetailComponent() {
        return flightDetailComponent;
    }

    public PreferenceComponent getPreferenceComponent() {
        return preferenceComponent;
    }

    public FlightPage clickContinue(){
        continueBtn.click();
        flightPage = PageFactory.initElements(driver,FlightPage.class);
        return flightPage;
    }
}
