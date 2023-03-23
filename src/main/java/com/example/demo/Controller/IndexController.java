package com.example.demo.Controller;

import com.example.demo.LoginService;
import com.example.demo.dto.UserSingleLoginMessageBodyReq;
import com.example.demo.dto.UserSingleLoginMessageReq;
import com.example.demo.utils.XmlUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/management")
public class IndexController {

    @Resource
    LoginService loginService;

    @GetMapping({"/login"})
    public String requestParam(@RequestParam(value = "PARAM") String PARAM) {

        UserSingleLoginMessageReq userSingleLoginMessageReq = new UserSingleLoginMessageReq();
        userSingleLoginMessageReq.setMessageHeader("02");
        UserSingleLoginMessageBodyReq body= new UserSingleLoginMessageBodyReq("999990011", "3123");
        //
        userSingleLoginMessageReq.setUserSingleLoginMessageBodyReq(body);
        String s1 = XmlUtils.beantoXml(userSingleLoginMessageReq, UserSingleLoginMessageReq.class,true);
        String login = loginService.login(s1);
        System.out.println(login);
        return null;

    }
}

