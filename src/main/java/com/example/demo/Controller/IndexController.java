package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/management")
public class IndexController {


    @GetMapping({"/login"})
    public String requestParam(@RequestParam(value = "PARAM") String PARAM) {

        System.out.println(PARAM);
        return null;

    }
}

