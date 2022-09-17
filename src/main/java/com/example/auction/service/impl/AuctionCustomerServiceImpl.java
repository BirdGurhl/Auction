package com.example.auction.service.impl;

import com.example.auction.mapper.AuctionCustomerMapper;
import com.example.auction.pojo.Auction;
import com.example.auction.service.AuctionCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionCustomerServiceImpl implements AuctionCustomerService {
    @Autowired
    private AuctionCustomerMapper auctionCustomerMapper;
    @Override
    public Auction getAuctionByActionId(Integer id) {
        return auctionCustomerMapper.selectAuctionByAuctionId(id);
    }
}
