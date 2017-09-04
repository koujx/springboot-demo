package com.kou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by KouJiaxing on 2017-9-4.
 */
@Controller
@MapperScan("com.kou.dao")
@EnableAutoConfiguration
public class MainApplication {

    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "hello world!";
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
