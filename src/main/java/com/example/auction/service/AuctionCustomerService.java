package com.example.auction.service;

import com.example.auction.pojo.Auction;

public interface AuctionCustomerService {
    /*根据id得到拍卖商品详情信息*/
    Auction getAuctionByActionId(Integer id);
}