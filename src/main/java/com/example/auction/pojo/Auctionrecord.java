package com.example.auction.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Auctionrecord implements Serializable {
    private Integer id;

    private Integer userid;

    private Integer auctionid;

    private Date auctiontime;

    private BigDecimal auctionprice;

    private static final long serialVersionUID = 1L;
    private User user;//一条竞拍记录对应一个竞拍用户
    //注意要生成get/set方法否则汇报名称无效
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public static long getSerialVersionUID(){
        return serialVersionUID;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getAuctionid() {
        return auctionid;
    }

    public void setAuctionid(Integer auctionid) {
        this.auctionid = auctionid;
    }

    public Date getAuctiontime() {
        return auctiontime;
    }

    public void setAuctiontime(Date auctiontime) {
        this.auctiontime = auctiontime;
    }

    public BigDecimal getAuctionprice() {
        return auctionprice;
    }

    public void setAuctionprice(BigDecimal auctionprice) {
        this.auctionprice = auctionprice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", auctionid=").append(auctionid);
        sb.append(", auctiontime=").append(auctiontime);
        sb.append(", auctionprice=").append(auctionprice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}