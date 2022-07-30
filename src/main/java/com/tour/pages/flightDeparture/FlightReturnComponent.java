package com.tour.pages.flightDeparture;

import com.tour.pages.common.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class FlightReturnComponent extends AbstractComponent {

    @FindBy(xpath = "//*[contains(text(),'Select Flight - Departure')]/parent::div/table[2]/tbody/tr/th/label")
    private List<WebElement> flightRetlist;

    public FlightReturnComponent(WebDriver driver) {
        super(driver);
    }


    public void selectReturnDeparture(String airline,String cls){

        String  id = flightRetlist.stream()
                .filter(e ->e.getText().equalsIgnoreCase(airline))
                .map(element -> element.getAttribute("id"))
                .collect(Collectors.joining());


        List<WebElement> elementx = driver.findElements(By.xpath("//*[contains(text(),'Departure')]/following-sibling::table[2]/tbody/tr[contains(@aria-labelledby,'"+id+"')]/td/input"));
        elementx.stream().
                filter(element -> element.getAttribute("value").equalsIgnoreCase(cls))
                .forEach(element -> element.click());


    }

    @Override
    public boolean isDisplayed() {
    return  wait.until((d) -> this.flightRetlist.size()>1);
    }
}
