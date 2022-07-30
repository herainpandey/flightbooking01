package com.tour.pages.flightDetail;

import com.tour.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class FlightDetailComponent extends AbstractComponent {

    @FindBy(xpath = "//input[@name='tripType']")
    private List<WebElement> type;

    @FindBy(xpath = "//select[@name='passCount']")
    private WebElement pessangers;

    @FindBy(xpath = "//select[@name='fromPort']")
    private WebElement departFrom;

    @FindBy(xpath = "//select[@name='fromMonth']")
    private WebElement month;

    @FindBy(xpath = "//select[@name='fromDay']")
    private WebElement day;

    @FindBy(xpath = "//select[@name='toPort']")
    private WebElement arrivingIn;

    @FindBy(xpath = "//select[@name='toMonth']")
    private WebElement returnMonth;

    @FindBy(xpath = "//select[@name='toDay']")
    private WebElement returnDate;


    public FlightDetailComponent(WebDriver driver) {
        super(driver);
    }

    public void setFlightDetails(Map<String,String> values){
        setType(type,values.get("type"));
        selectionValue(pessangers,values.get("pessangers"));
        selectionValue(departFrom,values.get("departFrom"));
        selectionValue(month,values.get("month"));
        selectionValue(day,values.get("day"));
        selectionValue(arrivingIn,values.get("arrivingIn"));
        selectionValue(returnMonth,values.get("returnMonth"));
        selectionValue(returnDate,values.get("returnDate"));
    }

    public void setType(List<WebElement> elements,String tripType){
    elements.stream().filter(d ->  d.getText().equalsIgnoreCase(tripType))
            .forEach(val -> val.click());
    }

    public void selectionValue(WebElement element,String value){
        Select sel = new Select(element);
        sel.selectByVisibleText(value);
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(d -> pessangers.isDisplayed());

    }
}
