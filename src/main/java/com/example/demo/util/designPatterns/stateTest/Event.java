package com.example.demo.util.designPatterns.stateTest;



public enum Event {

    /**
     * 创建
     */
    INIT(0, "创建"),

    /**
     * 首次质检
     */
    FIRST_CHECK(1, "首次质检"),

    /**
     * 二次质检
     */
    SECOND_CHECK(3, "二次质检"),

    /**
     * 审批中
     */
    APPROVAL(5, "审批中"),

    /**
     * 特情入库
     */
    SPECIAL(6, "特情入库"),

    /**
     * 入库
     */
    INSTOCK(7, "入库"),

    /**
     * 拒收
     */
    REJECT(8, "拒收"),


    /**
     * 入库单关闭
     */
    INSTOCK_CLOSE(9, "入库单关闭"),

    /**
     * 特批入库
     */
    SPECIAL_APPROVE(10, "特批入库")
    ;

    String value;
    int code;

    Event(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static int controlSendDealStatus(int code){
        if (code == SPECIAL.code) {
            return INSTOCK.code;
        }else if (code == SPECIAL_APPROVE.code) {
            return INSTOCK.code;
        }
        return code;
    }
}
