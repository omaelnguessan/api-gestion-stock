package com.omael.gestiondestock.exception;

public enum ErrorCodes {
    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALID(1001),
    CATEGORY_NOT_FOUND(2000),
    CATEGORY_NOT_VALID(2001),
    // TODO complete the rest of the Error codes
    CUSTOMER_NOT_FOUND(3000),
    ORDER_CUSTOMER_NOT_FOUND(4000),
    ORDER_PROVIDER_NOT_FOUND(5000),
    COMPANIES_NOT_FOUND(6000),
    PROVIDER_NOT_FOUND(7000),
    LINE_ORDER_CUSTOMER_NOT_FOUND(8000),
    LINE_ORDER_PROVIDER_NOT_FOUND(9000),
    LINE_SALE_NOT_FOUND(10000),
    MVT_STK_NOT_FOUND(11000),
    USER_NOT_FOUND(12000),
    SALE_NOT_FOUND(13000);


    private int code;
    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
