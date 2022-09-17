package com.example.auction.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

//生成验证码的控制器类
@Controller
public class VrifyCodeController {

    @Autowired
    private DefaultKaptcha captchaProducer;

    //获取验证码
    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        byte[] captchaChallengeAsJpeg=null;
        ByteArrayOutputStream jpegOutputStream=new ByteArrayOutputStream();
        try {
            //生产验证码字符串保存到session中
            String createText=captchaProducer.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode",createText);
            //使用生产的验证码字符串来进行返回一个BufferedImage 对象 并且转为 byte 写入到byte 数组中
            BufferedImage challenge=captchaProducer.createImage(createText);
            ImageIO.write(challenge,"jpg",jpegOutputStream);
        }catch (IllegalArgumentException e){
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //定义response输出类型的image/jpeg类型，使用期response输出流的输出图片到byte数组中
        captchaChallengeAsJpeg=jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control","no-store");
        httpServletResponse.setHeader("Pragma","no-cache");
        httpServletResponse.setDateHeader("Expires",0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream=httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();

    }



}
