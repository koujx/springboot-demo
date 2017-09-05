package com.kou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by KouJiaxing on 2017-9-4.
 */
@SpringBootApplication
@RestController
@MapperScan("com.kou.dao")
public class MainApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "hello world!";
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
