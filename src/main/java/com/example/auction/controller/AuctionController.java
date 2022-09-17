package com.example.auction.controller;

import com.example.auction.pojo.Auction;
import com.example.auction.pojo.AuctionCustomer;
import com.example.auction.pojo.Auctionrecord;
import com.example.auction.pojo.User;
import com.example.auction.service.AuctionCustomerService;
import com.example.auction.service.AuctionService;
import com.example.auction.tools.AuctionCustomerException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class AuctionController {
    @Autowired
    private AuctionService auctionService;
    //常量
    private static final int pagSize = 10;//规定每页最多显示5条记录

    //BindingResult result 作用：用于对前端穿进来的参数进行校验，省去了大量的逻辑判断操作
    @RequestMapping("/getAllAuctions")
    public String selectAuctionList(Model model,
                                    @ModelAttribute(value = "condition") Auction
                                            auction,
                                    BindingResult result,
                                    @RequestParam(name = "pageNum", required =
                                            false, defaultValue = "1") int pageNum) {
//注意:一定要在查询数据之前调用此方法,否则放到后面，数据已经查询完成，没有任何作用
        PageHelper.startPage(pageNum, pagSize);
        List<Auction> auctionList = auctionService.getAllAuction(auction);
//将集合数据存储在域对象中
        model.addAttribute("auctionList", auctionList);
//获取分页相关的数据对象 通过依赖mybatis插件
        PageInfo pageInfo = new PageInfo(auctionList);
//注意事项：如果不使用依赖插件，就要如下编写全部分页信息
// int pageSize = pageInfo.getPageSize(); //每页显示的记录条件
// int pageNo = pageInfo.getPageNum(); //当前页号
// long totalCount = pageInfo.getTotal(); //总记录数
// int pages = pageInfo.getPages(); //总页数
// int prePage = pageInfo.getPrePage(); //上一页的页号
// int nextPage = pageInfo.getNextPage(); //下一页的页号
//把pageInfo存储在域对象当中，转发到index页面
        model.addAttribute("page", pageInfo);
        return "index";
    }

    @Autowired
    private AuctionCustomerService auctionCustomerService;

    //根据拍卖商品编号查询该商品详情信息
    @RequestMapping(value = "/getAuctionCustomerByAuctionId")
    public String getAuctionDetail(Integer auctionId, Model model) {
//从数据库得到拍卖商品详情信息
        Auction auction = auctionCustomerService.getAuctionByActionId(auctionId);
        model.addAttribute("auctionDetail", auction); //存储到域对象当中
        return "auctionDetail";
    }


    //saveAuctionRecord在auctionDetail.html的第51行
    @RequestMapping(value = "/saveAuctionRecord")
    public String addAuctionRecord(Auctionrecord record, HttpSession session) throws AuctionCustomerException {
        System.out.println("saveAuctionRecord");
//封装用户的ID
        User user = (User) session.getAttribute("user");
        record.setUserid(user.getUserid());
//进行封装当前时间
        record.setAuctiontime(new Date());
        System.out.println("当前活动时间"+new Date());
        auctionService.addAuctionRecored(record);
//重新刷新数据
        return "redirect:/getAuctionCustomerByAuctionId?auctionId=" + record.getAuctionid();
    }





    @RequestMapping(value = "/auctionResult")
    public String toAuctionResult(Model model){
        List<AuctionCustomer> list = auctionService.selectAuctionEndTime(); //结束活动的商品
        List<Auction> noEndList=auctionService.selectAuctionNoEndTime();//正在拍卖的商品信息
        model.addAttribute("endtimeList",list);
        model.addAttribute("noendtimeList",noEndList);
        return "auctionResult";
    }

    // 跳转到 发布拍卖品页面
    @RequestMapping(value = "/addAuction")
    public String toAddAuction() {
        return "addAuction";
    }

    @RequestMapping("/publishAuctions")
    public String addAuction(Auction auction, MultipartFile pic) throws IllegalStateException,IOException {
        auction.setAuctionpic(pic.getOriginalFilename()); //封装图片名称
        auction.setAuctionpictype(pic.getContentType()); //封装文件类型
        auctionService.addAuction(auction); //执行添加商品信息
//上传图片
        pic.transferTo(new File("D:\\test\\images\\"+pic.getOriginalFilename()));
        return "redirect:/getAllAuctions"; //发布成功后，自动跳转到index列表页面
    }

    //获取修改商品信息
    @RequestMapping(value = "/updateAuction/{auctionid}")
    public ModelAndView updateAuction(@PathVariable Integer auctionid){
        Auction auction = auctionService.findAuctionById(auctionid);
        ModelAndView mv = new ModelAndView();
        mv.addObject("auction",auction);
        mv.setViewName("update");
        return mv;
    }

    //修改竞拍商品信息
    @RequestMapping("/doupdate")
    public String doupdate(Auction auctioin){
        auctionService.updateAuction(auctioin);

        return "redirect:/getAllAuctions";

    }

    //删除竞拍商品
    @RequestMapping("/deleteAuction/{auctionid}")
    public String deleteAuction(@PathVariable Integer auctionid){
        this.auctionService.deleteAuction(auctionid);
        return "redirect:/getAllAuctions";
    }

}
