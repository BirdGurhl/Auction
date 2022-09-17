package com.example.auction.tools;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Configuration
public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o,
                                         Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        AuctionCustomerException customer = null;
        String errmsg = "";
        if (e instanceof AuctionCustomerException) {
            customer = (AuctionCustomerException) e;
            errmsg = customer.getMessage(); //读取不同的异常信息
        }else{ //其它的异常类型
            errmsg="其它的未知异常";
        }
        modelAndView.addObject("errorMsg", errmsg); //把异常信息存储在域对象当中，跟Model作用类似的
//封装要跳转的页面
        modelAndView.setViewName("errorPage");
        return modelAndView;
    }
}
