package com.chenliheadlines.controller;//package com.chenliheadlines.controller;
//
//import com.chenliheadlines.bean.Result;
//import com.chenliheadlines.bean.User;
//import com.chenliheadlines.service.UserService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class userController {
//
//    private final UserService userService;
//
//    public userController(UserService userService) {
//        this.userService = userService;
//    }
//
//    /**
//     * 注册
//     * @param user 参数封装
//     * @return Result
//     */
//    @RequestMapping("regist")
//    public Result regist(User user){
//        return userService.regist(user);
//    }
//
//    /**
//     * 登录
//     * @param user 参数封装
//     * @return Result
//     */
//    @RequestMapping("login")
//    public Result login(User user){
//        return userService.login(user);
//    }
//}

import com.chenliheadlines.bean.User;
import com.chenliheadlines.service.loginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
@Controller
public class userController {
    @Autowired
    loginServiceImpl userServiceImpl;

    @RequestMapping("")
    public String page(){
        return "page";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(User user, Map<String,Object> map){
        User user1 =  userServiceImpl.getUser(user.getPassword(),user.getUsername());

        if(user1 == null){
            map.put("msg","登入失败");
            return "login";
        }else{
            map.put("msg","登入成功");
            return "success";
        }

    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("doRegist")
    public String doRegist(User user, Map<String,Object> map){
        userServiceImpl.insertUser(user);
        map.put("msg","注册成功");
        return "success";
    }
}
