package com.tour.pages.orderDetail;

import com.tour.pages.common.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FlightSummary extends AbstractComponent {

    @FindBy(xpath = "//table[@id='confirm-table']/tbody/tr")
    private List<WebElement> orderlist;

    public FlightSummary(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    public void getDetails() {
        List<List<WebElement>> str = orderlist.stream()
                .map(d-> d.findElements(By.tagName("td"))).collect(Collectors.toList());

        List<String> value = str.stream().map(List::listIterator)
                .filter(val -> val.hasNext())
                .map(val2 -> val2.next()).map(gh -> gh.getText()).collect(Collectors.toList());



        value.stream().forEach(System.out::println);
    }
}