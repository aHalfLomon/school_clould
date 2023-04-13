package users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import users.config.SecurityUtil;
import users.model.dto.LogonUserDto;
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
public class UserController {

    @Autowired
    UserService userService;

    //发送验证码
    @GetMapping("/sedsms/{Sms}")
    public ResultData test1(@PathVariable("Sms") String Sms){
        SecurityUtil.XcUser user=SecurityUtil.getUser();
        List<SUser> list=userService.getAllUsers();
        return new ResultData("200","ok",list);
    }

    //注册
    @PostMapping("/logon")
    public ResultData Logon(@RequestBody LogonUserDto logonUserDto){
        userService.LogonUser(logonUserDto);
        return new ResultData("200","ok","logon");
    }

    //退出
    @PostMapping("/logout")
    public ResultData Logout(){
        return new ResultData("200","ok","logon");
    }

    //修改用户信息
    @PostMapping("/upuser")
    public ResultData upUser(@RequestBody SUser sUser){
        return new ResultData("200","ok","logon");
    }


}
