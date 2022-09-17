package com.example.auction.service.impl;

import com.example.auction.mapper.AuctionCustomerMapper;
import com.example.auction.mapper.AuctionMapper;
import com.example.auction.mapper.AuctionrecordMapper;
import com.example.auction.pojo.Auction;
import com.example.auction.pojo.AuctionCustomer;
import com.example.auction.pojo.AuctionExample;
import com.example.auction.pojo.Auctionrecord;
import com.example.auction.service.AuctionService;
import com.example.auction.tools.AuctionCustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
//@Service
//public class AuctionServcieImpl  implements AuctionService {
//
//    @Autowired
//    private AuctionMapper auctionMapper;
//    @Override
//    public List<Auction> getAllAuction(Auction auction) {
//        return auctionMapper.selectByExample(auction); //null:表示没有条件，也就是查询所有
//    }
//
//}

@Service
public class AuctionServcieImpl implements AuctionService {
    @Autowired
    private AuctionMapper auctionMapper;

    @Override
    public List<Auction> getAllAuction(Auction auction) {
        //注意事项：这里的example 是所有条件查询映射
        AuctionExample example = new AuctionExample();
        AuctionExample.Criteria criteria = example.createCriteria();
        //进行动态条件查询
        if (auction != null) { //非空验证
            //判断用户是否输入了拍卖品名称
            if (auction.getAuctionname() != null &&
                    !"".equals(auction.getAuctionname())) {
                //按照拍卖品名称模糊查询
                criteria.andAuctionnameLike("%" + auction.getAuctionname() +
                        "%");
            }
            //判断用户是否输入了拍卖品描述
            if (auction.getAuctiondesc() != null &&
                    !"".equals(auction.getAuctiondesc())) {
                //按照拍卖器描述进行模糊查询
                criteria.andAuctiondescLike("%" + auction.getAuctiondesc() +
                        "%");
            }
            //判断用户是否输入了拍卖开始时间
            if (auction.getAuctionstarttime() != null) {
                //拍卖时间大于或等于指定时间
                criteria.andAuctionstarttimeGreaterThanOrEqualTo(auction.getAuctionstarttime());
            }
            //判断用户是否输入了拍卖结束时间
            if (auction.getAuctionendtime() != null) {
                //拍卖时间小于或等于指定时间
                criteria.andAuctionendtimeLessThanOrEqualTo(auction.getAuctionendtime());
            }
            //判断用户是否输入了起拍价
            if (auction.getAuctionstartprice() != null) {
                //查询大于指定起拍价
                criteria.andAuctionstartpriceGreaterThan(auction.getAuctionstartprice());
            }
            //降序排序，根据开始时间进行降序排序
            example.setOrderByClause("auctionstarttime desc");
        }
        return auctionMapper.selectByExample(example); //null:表示没有条件，也就是查询所有
    }

    @Autowired
    private AuctionrecordMapper auctionrecordMapper;
    @Autowired
    private AuctionCustomerMapper auctionCustomerMapper;

    /**
     * 1.有竞拍记录
     * a.你出的价格不能低于所有价格的中的最高价
     * 给出错误提示: 不能低于所有价格的最高价 -> 异常
     * b.你竞拍的时间不能晚于 当前活动的结束时间
     * 给出错误提示: 不能晚于活动的结束时间 -> 异常
     * 2.没有竞拍记录
     * 如果你出的价格低于 起拍价
     * 给出错误提示: 当前价格不能低于起拍价
     */
    @Override
    public void addAuctionRecored(Auctionrecord record) throws
            AuctionCustomerException {
//得到竞拍的商品信息， 注意事项：该Auction拿旧的数据
        Auction auction = auctionCustomerMapper.selectAuctionByAuctionId(record.getAuctionid());
//判断竞拍时的时间是否晚于活动结束时间
        if (new Date().after(auction.getAuctionendtime())) {

            System.out.println(new Date()+"<"+auction.getAuctionendtime()+auction.getAuctionname());
            throw new AuctionCustomerException("当前时间不能晚于活动结束时间！！！");
        }
//判断当前拍卖商品是否存在竞拍记录
        System.out.println("竞拍记录："+auction.getAuctionrecordList().size());
        if (auction.getAuctionrecordList().size() > 0) { //有过的竞拍记录：在Auction的实体类中
//得到出价最高的那条存在竞技记录时，获得最大竞拍价格的记录
            Auctionrecord maxRecored = auction.getAuctionrecordList().get(0);
//判断当前竞拍价格是否小于最高竞拍价格，如果小于就给出提示
            if (record.getAuctionprice().compareTo(maxRecored.getAuctionprice()) < 1) {
//说明你出的价格是否比别的低
                throw new AuctionCustomerException("当前价格不能小于所有记录中的最高价格！！！");
            }
        } else { //没有任何竞拍记录
//如果当前竞拍的价格小于了商品起拍价格时，给出提示信息
            if (record.getAuctionprice().compareTo(auction.getAuctionstartprice()) < 1) {
//比起拍价要低
                System.out.println(auction.getAuctionstartprice());
                throw new AuctionCustomerException("当前价格不能小于起拍价！！！");
            }
        }
//如果以上都没有进入，说明符合竞拍要求，就添加一条新竞拍记录到数据库中
        auctionrecordMapper.insert(record);
    }


    @Override
    public List<AuctionCustomer> selectAuctionEndTime() {
        return auctionCustomerMapper.selectAuctionEndTime();
    }

    @Override
    public List<Auction> selectAuctionNoEndTime() {
        return auctionCustomerMapper.selectAuctionNoEndTime();
    }

    @Override
    public void addAuction(Auction auction) {
        auctionMapper.insert(auction);
    }

    @Override
    public Auction findAuctionById(Integer auctionid) {
        return auctionMapper.selectByPrimaryKey(auctionid);
    }

    @Override
    public int updateAuction(Auction auction) {
        return auctionMapper.updateByPrimaryKeySelective(auction);
    }

    @Override
    public void deleteAuction(Integer auctionid) {

        this.auctionMapper.deleteByPrimaryKey(auctionid);
    }
}
