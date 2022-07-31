package utils;

public enum TestDataEnum {

    RADIO_BUTTON1("Radio1"),
    RADIO_BUTTON2("Radio2"),
    RADIO_BUTTON3("Radio3"),
    CHECKBOX_OPTION1("Option1"),
    CHECKBOX_OPTION2("Option2"),
    CHECKBOX_OPTION3("Option3");

    private final String values;

    TestDataEnum(String values) {
        this.values=values;
    }

    public String getValues(){
        return values;
    }
}
