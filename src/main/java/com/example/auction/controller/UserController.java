package com.example.auction.controller;

import com.example.auction.pojo.User;
import com.example.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //访问的是哪个页面，就会是跳转到哪个页面中
    @RequestMapping(value = "/{page}")
    public String page(@PathVariable String page) {
        return page;
    }

    @PostMapping("/doLogin")
    public String doLogin(String username, //用户输入用户名
                          String userPassword, //用户输入密码
                          String valideCode, //用户输入验证码
                          HttpSession session, //session对象
                          Model model) {
//从session当中获取系统随机生成的验证码 vrifyCode
        String vcode = session.getAttribute("vrifyCode").toString();
        System.out.println("vcode=" + vcode);
//判断这两个验证码是否一致
//equalsIgnoreCase作用区分大小写
//注意事项：下面是不等于号的
        if (!vcode.equalsIgnoreCase(valideCode)) {
//不相等，就输出一个相应的错误提示 这里需要一个Model对象
//login页面的35行 errorMsg
            model.addAttribute("errorMsg", "验证码不正确！");
            return "login";
        }
//验证用户名和密码是否正确
        User user = userService.doLogin(username, userPassword);
        System.out.println("user=" + user);
//判断数据
        if (user == null) {
//说明用户名或者密码输入不正确
            model.addAttribute("errorMsg", "用户名或者密码输入不正确！");
            return "login";
        }
//登录成功后，把当前登录的用户对象存储在session域对象当中，以备后用
        session.setAttribute("user", user);
        return "redirect:/getAllAuctions"; //先读取所有拍卖商品信息数据
    }

    /**
     * 注意事项：这里方法的使用的是映射所有用户信息，为什么不是使用指定形参呢？
     * 形参如：String name,String Password等等，原因是单个还可以，多个的话，太麻烦了
     */
    @RequestMapping("/registerUser")
    public String doRegister(User user) {
/**
 * 刚刚注册的用户默认为普通用户 ： userisadmin
 * 默认 0：普通用户，1：管理员用户
 */
        user.setUserisadmin(0);
        userService.registerUser(user);
//可以在return 行上断点查看用户信息
        return "redirect:login"; //重定向到登录页面
    }

    //注销
    @RequestMapping(value = "/doLogout")
    public String doLogout(HttpSession session) {
        session.invalidate();
        return "redirect:login"; //重定向到登录页面
    }
}