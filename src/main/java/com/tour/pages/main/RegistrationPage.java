package com.tour.pages.main;

import com.tour.pages.confirmation.RegistrationConfirmationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {


    private WebDriver driver;

    @FindBy(xpath = "//input[@name='register']")
    private WebElement button;

    private ContactInformationPage contactInformationPage;
    private MailingInformationPage mailingInformationPage;
    private UserInformationPage userInformationPage;
    private RegistrationConfirmationPage registrationConfirmationPage;

    public RegistrationPage(final WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        contactInformationPage = PageFactory.initElements(driver,ContactInformationPage.class);
        mailingInformationPage =PageFactory.initElements(driver,MailingInformationPage.class);
        userInformationPage =PageFactory.initElements(driver,UserInformationPage.class);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
    }


    public ContactInformationPage getContactInformationPage() {
        return contactInformationPage;
    }

    public MailingInformationPage getMailingInformationPage() {
        return mailingInformationPage;
    }

    public UserInformationPage getUserInformationPage() {
        return userInformationPage;
    }

    public RegistrationConfirmationPage submitRegistration(){
         button.click();
         registrationConfirmationPage = PageFactory.initElements(driver,RegistrationConfirmationPage.class);
         return registrationConfirmationPage;
    }


}
