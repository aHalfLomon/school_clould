package users.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Classname test
 * @Description TODO
 * @Date 2023/4/4 11:10
 * @Created by wang
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@RequestMapping("/test")
public class test {
    @GetMapping("/test1")
    public String test1(){
        return "index.html";
    }
}
