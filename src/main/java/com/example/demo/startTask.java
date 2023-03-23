package com.example.demo;

import javax.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @description：1
 * @date ：Created in 2023/3/23 14:42
 * @version: 1
 */
@Component
public class startTask implements CommandLineRunner {
@Resource
Service service;
@Resource
LoginService loginService;

    @Override
    public void run(String... args) throws Exception {
        try {
//            String login = loginService.login("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"
//                + "<TX>\n"
//                + "    <MESSAGE_HEADER>01</MESSAGE_HEADER>\n"
//                + "    <MESSAGE_BODY>\n"
//                + "        <USERID>320000001</USERID>\n"
//                + "        <PARAM>20150504123111225</PARAM>   \n"
//                + "    </MESSAGE_BODY>\n"
//                + "</TX>");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
