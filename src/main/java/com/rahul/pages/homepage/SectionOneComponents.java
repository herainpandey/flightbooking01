package com.rahul.pages.homepage;

import com.rahul.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SectionOneComponents extends AbstractComponent {

    @FindBy(xpath = "//input[@name='radioButton']")
    List<WebElement> radiobutton;

    @FindBy(xpath = "//ul[@id='ui-id-1']/li")
    List<WebElement> countrySuggestion;

    @FindBy(xpath = "//input[@placeholder='Type to Select Countries']")
    WebElement contry;

    @FindBy(xpath = "//select[@id='dropdown-class-example']")
    WebElement selectOptiondropdown;

    @FindBy(xpath = "//div[@id='checkbox-example']//label")
    WebElement selectCheckbox;

    public SectionOneComponents(WebDriver driver) {
        super(driver);
    }

    public void selectRadio(String radiobutton){
        this.radiobutton.stream().filter(element -> element.getAttribute("value").equalsIgnoreCase(radiobutton))
                .forEach(WebElement::click);
    }

    public void selectCountry(String country){
        contry.sendKeys(country);
        wait.until(d -> countrySuggestion.size()>0);
        countrySuggestion.stream().filter(d->d.getText().equalsIgnoreCase(country)).forEach(WebElement::click);
    }

    public void selectDropDownOption(String options){

    }

    public void selectCheckboxOption(String options){


    }


    @Override
    public boolean isDisplayed() {

        return wait.until(d -> contry.isDisplayed());
    }
}
