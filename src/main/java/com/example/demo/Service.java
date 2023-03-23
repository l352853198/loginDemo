package com.example.demo;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @description：1
 * @date ：Created in 2023/3/23 14:42
 * @version: 1
 */
@Component
public class Service {

    @Resource
    LoginService loginService;
    public void a(){
        String a = loginService.login("a");
        System.out.println(a);
    }
}
