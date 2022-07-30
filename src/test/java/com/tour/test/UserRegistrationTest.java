package com.tour.test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.tour.pages.billingAddress.BillingAddress;
import com.tour.pages.flightDeparture.FlightPage;
import com.tour.pages.flightDetail.FlightDetailPage;
import com.tour.pages.confirmation.RegistrationConfirmationPage;
import com.tour.pages.main.RegistrationPage;
import com.tour.pages.orderDetail.FlightSummary;
import com.tour.test.factory.TestDataFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UserRegistrationTest extends  BaseTest{

    private RegistrationPage registrationPage;
    private RegistrationConfirmationPage registrationConfirmationPage;
    private FlightDetailPage flightDetailPage;
    private FlightPage flightPage;
    private BillingAddress billingAddress;
    private FlightSummary flightSummary;



    @BeforeTest
    public void initializePages(){
        registrationPage = new RegistrationPage(driver);
    }


    @Test
    public void enterResgistrationTest(){
        try {
            registrationPage.goTo();
            Assert.assertTrue(registrationPage.getContactInformationPage().isDisplayed(), "Element not present");
            registrationPage.getContactInformationPage().enterDetails(TestDataFactory.getValue("CI"));
            Assert.assertTrue(registrationPage.getMailingInformationPage().isDisplayed(), "Element not present");
            registrationPage.getMailingInformationPage().enterDetails(TestDataFactory.getValue("MI"));
            Assert.assertTrue(registrationPage.getUserInformationPage().isDisplayed(), "Element not present");
            registrationPage.getUserInformationPage().enterDetails(TestDataFactory.getValue("UI"));
            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
            registrationConfirmationPage = registrationPage.submitRegistration();
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test(dependsOnMethods = "enterResgistrationTest")
    public void navigateToFlightDetailPage(){
        try{
        Assert.assertTrue(registrationConfirmationPage.isDisplayed());
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        flightDetailPage = registrationConfirmationPage.flightslinkClick();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test(dependsOnMethods = "navigateToFlightDetailPage")
    public void enterFlightDetails(){
        flightDetailPage.getFlightDetailComponent().setFlightDetails(TestDataFactory.getValue("FD"));
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        flightDetailPage.getPreferenceComponent().setPreferenceDetails(TestDataFactory.getValue("PC"));
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        flightPage = flightDetailPage.clickContinue();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));

    }

    @Test(dependsOnMethods = "enterFlightDetails")
    public void selectDepartureAndReturn(){
        flightPage.getFlightDepartureComponent().selectFlightDeparture("Qatar","Business Class");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        flightPage.getFlightReturnComponent().selectReturnDeparture("British Airways","First Class");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));
        billingAddress = flightPage.clickContinue();
    }

    @Test(dependsOnMethods = "selectDepartureAndReturn")
    public void submitBillingAddress(){
        billingAddress.enterBillingAddress(TestDataFactory.getValue("BA"));
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        flightSummary = billingAddress.submitAddress();
    }

    @Test(dependsOnMethods = "submitBillingAddress")
    public void printflightSummary(){
        flightSummary.getDetails();
    }

}
