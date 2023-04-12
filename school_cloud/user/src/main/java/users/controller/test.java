package users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import users.config.SecurityUtil;
import users.model.po.SUser;
import users.model.utilsDto.ResultData;
import users.service.UserService;

import java.util.List;

/**
 * @Classname test
 * @Description TODO
 * @Date 2023/4/4 11:10
 * @Created by wang
 */
@RestController
@RequestMapping("/user")
public class test {

    @Autowired
    UserService userService;

    @GetMapping("/x")
    public ResultData test1(){
        SecurityUtil.XcUser user=SecurityUtil.getUser();
//        System.out.println(user.getUserId());
        List<SUser> list=userService.getAllUsers();
        return new ResultData("200","ok",list);
    }
}
