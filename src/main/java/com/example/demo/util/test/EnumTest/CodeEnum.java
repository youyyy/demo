package com.example.demo.util.test.EnumTest;

/**
 * @Description
 * @Author youyi
 * @Date 2019/7/1915:50
 **/
public enum CodeEnum {
    ERROR_CODE(500,"error"),
    SUCCESS_CODE(200,"success")
    ;
    private int enumKey;
    private String enumValue;

    private CodeEnum(int enumKey, String enumValue){
        this.enumKey = enumKey;
        this.enumValue = enumValue;
    }

    public int getEnumKey() {
        return enumKey;
    }

    public String getEnumValue() {
        return enumValue;
    }
}
