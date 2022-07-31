package com.rahul.pages.homepage;

import com.rahul.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RahulShattyHompage  {

    private SectionTwoComponents sectionTwoComponents;
    private SectionOneComponents sectionOneComponents;
    private SectionThreeComponents sectionThreeComponents;
    private WebDriver driver;

    public RahulShattyHompage(final WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        sectionOneComponents = PageFactory.initElements(driver,SectionOneComponents.class);
        sectionTwoComponents = PageFactory.initElements(driver,SectionTwoComponents.class);
        sectionThreeComponents = PageFactory.initElements(driver,SectionThreeComponents.class);
    }

    public SectionOneComponents getSectionOneComponents() {
        return sectionOneComponents;
    }

    public SectionTwoComponents getSectionTwoComponents() {
        return sectionTwoComponents;
    }

    public SectionThreeComponents getSectionThreeComponents() {
        return sectionThreeComponents;
    }

    public void goTo(String url){
        System.out.println("going to load url " + url);
        this.driver.get(url);
    }
}
