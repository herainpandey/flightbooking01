package com.tour.pages.confirmation;

import com.tour.pages.common.AbstractComponent;
import com.tour.pages.flightDetail.FlightDetailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationConfirmationPage extends AbstractComponent {

    FlightDetailPage flightDetailPage;

    @FindBy(xpath = "//a[text()='Flights']")
    private WebElement flightslink;


    public RegistrationConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public FlightDetailPage flightslinkClick(){
        flightslink.click();
        flightDetailPage = PageFactory.initElements(driver,FlightDetailPage.class);
        return flightDetailPage;
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(d->flightslink.isDisplayed());
    }
}
