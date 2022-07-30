package com.tour.pages.flightDetail;

import com.tour.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class PreferenceComponent extends AbstractComponent {

    @FindBy(xpath = "//input[@name='servClass']")
    private List<WebElement> serviceClass;

    @FindBy(xpath = "//select[@name='airline']")
    private WebElement airlinePref;


    public PreferenceComponent(WebDriver driver) {
        super(driver);
    }

    public void setPreferenceDetails(Map<String,String> values){
        setType(serviceClass,values.get("service"));
        selectionValue(airlinePref,values.get("airlinePref"));
    }

    public void setType(List<WebElement> elements,String serviceType){
    elements.stream().filter(d ->  d.getText().equalsIgnoreCase(serviceType))
            .forEach(val -> val.click());
    }

    public void selectionValue(WebElement element,String value){
        Select sel = new Select(element);
        sel.selectByVisibleText(value);
    }



    @Override
    public boolean isDisplayed() {
        return wait.until(d -> airlinePref.isDisplayed());

    }
}
