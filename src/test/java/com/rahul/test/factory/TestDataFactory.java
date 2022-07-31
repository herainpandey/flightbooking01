package com.rahul.test.factory;

import org.testng.collections.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class TestDataFactory {

    private static final Supplier<Map<String,String>> CI = () -> {
        Map<String,String> contactInfo = Maps.newHashMap();
        contactInfo.put("firtName","mohit");
        contactInfo.put("lastName","joshi");
        contactInfo.put("phoneNum","9874332998");
        contactInfo.put("email","rohit.joshi@gmail.com");
        return contactInfo;
    };

    private static final Supplier<Map<String,String>> MI = () -> {
        Map<String,String> mailInfo = Maps.newHashMap();
        mailInfo.put("address","C-67");
        mailInfo.put("city","Patiyala");
        mailInfo.put("state","Punjab");
        mailInfo.put("postalCode","1177281");
        mailInfo.put("countryName","BARBADOS");
        return mailInfo;
    };

    private static final Supplier<Map<String,String>> UI = () -> {
        Map<String,String> userInfo = Maps.newHashMap();
        userInfo.put("userName","mohit");
        userInfo.put("password","1234567");
        userInfo.put("confirmPassword","1234567");
        return userInfo;
    };

    private static final Supplier<Map<String,String>> FD = () -> {
        Map<String,String> flightdetail = new HashMap<>();
        flightdetail.put("type","One Way");
        flightdetail.put("pessangers","4");
        flightdetail.put("departFrom","London");
        flightdetail.put("month","April");
        flightdetail.put("day","4");
        flightdetail.put("arrivingIn","Sydney");
        flightdetail.put("returnMonth","October");
        flightdetail.put("returnDate","4");
        return flightdetail;
    };

    private static final Supplier<Map<String,String>> PC = () -> {
        Map<String,String> preferencedetail = new HashMap<>();
        preferencedetail.put("service","Business class");
        preferencedetail.put("airlinePref","Unified Airlines");
        return preferencedetail;
    };


    private static final Supplier<Map<String,String>> BA = () -> {
        Map<String,String> billingAddr = new HashMap<>();
        billingAddr.put("addressl1","C-83 Burete");
        billingAddr.put("addressl2","John road");
        billingAddr.put("city","Los Angelis");
        billingAddr.put("state","Unified America");
        billingAddr.put("postal","2709937");
        return billingAddr;
    };

    private static final Map<String, Supplier<Map<String, String>>> MAP =new HashMap<>();

    static {
        MAP.put("CI",CI);
        MAP.put("MI",MI);
        MAP.put("UI",UI);
        MAP.put("FD",FD);
        MAP.put("PC",PC);
        MAP.put("BA",BA);
    }

    public static Map<String, String> getValue(String supplier){
        return MAP.get(supplier).get();
    }

    }
