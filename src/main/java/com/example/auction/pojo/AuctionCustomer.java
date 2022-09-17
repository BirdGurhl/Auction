package com.example.auction.pojo;


public class AuctionCustomer extends Auction {
    private String auctionprice; //成交价格
    private String username; //成交人
    public String getAuctionprice() {
        return auctionprice;
    }
    public void setAuctionprice(String auctionprice) {
        this.auctionprice = auctionprice;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}