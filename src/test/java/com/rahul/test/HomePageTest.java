package com.rahul.test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rahul.pages.homepage.RahulShattyHompage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.DBUtils;
import utils.ExcelUtils;
import utils.PropertyReader;
import utils.TestDataEnum;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static utils.TestDataEnum.RADIO_BUTTON1;

public class HomePageTest extends BaseTest{
    RahulShattyHompage rahulShattyHompage;

    @BeforeTest
    public void initializePages() throws IOException {
        rahulShattyHompage = new RahulShattyHompage(driver);
        rahulShattyHompage.goTo(PropertyReader.getDataFromProperity("RSURL"));
    }

    @Test
    public void radioButtonTest(){
        rahulShattyHompage.getSectionOneComponents().isDisplayed();
        rahulShattyHompage.getSectionOneComponents().selectRadio(RADIO_BUTTON1.getValues());
    }


    @Test(enabled = false, dataProvider = "getData")
    public void selectCountry(String country){
        rahulShattyHompage.getSectionOneComponents().selectCountry(country);
    }


    @DataProvider
    public Object[][] getData() throws IOException {
        return ExcelUtils.getExcelData();
    }

    @Test
    public void checkAlertUsingSql() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        SoftAssert softAssert = new SoftAssert();
        List<String> firstName;
        String query="select firstName from emp_detail;";
        firstName = DBUtils.getDataFromDB(query);
        rahulShattyHompage.getSectionTwoComponents().enterName(firstName.get(0));
        String message = rahulShattyHompage.getSectionTwoComponents().clickAlertBtn();
        softAssert.assertTrue(message.contains(firstName.get(0)),"Alert messge doesn't contains expected name");
        softAssert.assertAll();
    }


    @Test
    public void windowValidationTest(){
        rahulShattyHompage.getSectionTwoComponents().newWindowValidate();
    }

    @Test
    public void validateTablePrice(){
        rahulShattyHompage.getSectionThreeComponents().getTableTotalValue();
    }

    @Test
    public void validateHoverElement() throws InterruptedException {
        rahulShattyHompage.getSectionThreeComponents().mouseOver("Top");
    }

    @AfterMethod
    public void waitforfewSec(){
        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);
    }
}
