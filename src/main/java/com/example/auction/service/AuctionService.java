package com.example.auction.service;

import com.example.auction.pojo.Auction;
import com.example.auction.pojo.AuctionCustomer;
import com.example.auction.pojo.Auctionrecord;
import com.example.auction.tools.AuctionCustomerException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuctionService {
    //获取所有的竞拍商品的信息
    List<Auction> getAllAuction(Auction auction);
    //添加竞拍记录
    void addAuctionRecored(Auctionrecord record)throws AuctionCustomerException;
    //拍卖已经结束的商品
    List<AuctionCustomer> selectAuctionEndTime();
    //正在拍卖的商品
    List<Auction> selectAuctionNoEndTime();
    //发布拍卖商品信息
    void addAuction(Auction auction);
    //查找单个竞拍商品
    Auction findAuctionById(Integer auctionid);
    //修改竞拍商品
    int updateAuction(Auction auction);
    //删除
    void deleteAuction(Integer auctionid);

}
