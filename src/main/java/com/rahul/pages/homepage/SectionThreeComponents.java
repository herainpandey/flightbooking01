package com.rahul.pages.homepage;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rahul.pages.common.AbstractComponent;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SectionThreeComponents extends AbstractComponent {


    @FindBy(xpath = "//legend[normalize-space()='Web Table Example']")
    WebElement tableHead;

    @FindBy(xpath = "//table[@name='courses']//tr/th")
    List<WebElement> table;

    @FindBy(xpath = "//button[@id='mousehover']")
    WebElement mouseOver;

    @FindBy(xpath = "//h1[normalize-space()='Practice Page']")
    WebElement pageTitle;



    public SectionThreeComponents(WebDriver driver) {
        super(driver);
    }

    public void getTableTotalValue(){
        scrollToElementAction(tableHead);
        int actual_position = 0;
        int curr_position = 1;
                for(WebElement element: table){
                    if(element.getText().equalsIgnoreCase("Price")){
                        actual_position=curr_position;
                    }else {
                        curr_position++;
                    }
                }
          List<WebElement> getColumnval = driver.findElements(By.xpath("//table[@name='courses']//tr/td["+ actual_position +"]"));

        int totalSum =getColumnval.stream().collect(Collectors.summingInt(d-> Integer.parseInt(d.getText())));
        System.out.println("Actual Total Values " + totalSum);

        Assert.assertEquals(totalSum,235,"expacted values are different from actual");
    }

    public void mouseOver(String moveTo) throws InterruptedException {
        moveToElement(mouseOver);
        List<WebElement> hoveredElement = driver.findElements(By.xpath("//div[@class='mouse-hover']/div/a"));
        hoveredElement.stream().filter(ele -> ele.getText().equalsIgnoreCase(moveTo))
                .forEach(element -> element.click());

        Thread.sleep(1000);

        switch (moveTo){
            case "Top":
                Assert.assertTrue(pageTitle.isDisplayed(),"Not Scrolled to Top");
                System.out.println("Moved to top");
                break;
            case "Reload":
                wait.until(d->pageTitle.isDisplayed());
                Assert.assertTrue(pageTitle.isDisplayed(),"Page reloaded");
                System.out.println("Moved to top after reload");
                break;
        }
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }


}
