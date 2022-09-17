package com.example.auction.tools;

/**
 * 自定义一个异常类
 */
public class AuctionCustomerException extends Exception {
    private String message;
    @Override
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    //无参构造
    public AuctionCustomerException() {
    }
    //有参构造
    public AuctionCustomerException(String message) {
        this.message = message;
    }

}
