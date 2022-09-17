package com.example.auction.mapper;

import com.example.auction.pojo.Auction;
import com.example.auction.pojo.AuctionCustomer;

import java.util.List;

public interface AuctionCustomerMapper {
    Auction selectAuctionByAuctionId(Integer auctionId);
    //拍卖已经结束的商品
    List<AuctionCustomer> selectAuctionEndTime();
    //正在拍卖的商品
    List<Auction> selectAuctionNoEndTime();
}
