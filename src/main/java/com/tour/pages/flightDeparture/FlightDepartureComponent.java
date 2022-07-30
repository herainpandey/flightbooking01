package com.tour.pages.flightDeparture;

import com.tour.pages.common.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class FlightDepartureComponent extends AbstractComponent {


    @FindBy(xpath = "//*[contains(text(),'Departure')]/following-sibling::table[1]/tbody/tr/th/label")
    private List<WebElement> flightDeplist;

    public FlightDepartureComponent(WebDriver driver) {
        super(driver);
    }

    public void selectFlightDeparture(String airline,String cls){

        String  id = flightDeplist
                .stream()
                .filter(e ->e.getText().equalsIgnoreCase(airline))
                .map(t->t.getAttribute("id")).collect(Collectors.joining());

        List<WebElement> elementx = driver.findElements(By.xpath("//*[contains(text(),'Departure')]/following-sibling::table[1]/tbody/tr[contains(@aria-labelledby,'"+id+"')]/td/input"));

        elementx.stream()
                .filter(element -> element
                        .getAttribute("value")
                        .equalsIgnoreCase(cls))
                        .forEach(element -> element.click());

    }

    @Override
    public boolean isDisplayed() {
        return  wait.until((d) -> this.flightDeplist.size()>1);
    }
}
