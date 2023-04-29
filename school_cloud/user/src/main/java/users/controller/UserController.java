package users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import users.config.SecurityUtil;
import users.model.dto.LogonUserDto;
import users.model.dto.UserUn;
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
@RequestMapping("/user/open")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    //发送验证码
    @GetMapping("/sedsms/{Phone}")
    public ResultData test1(@PathVariable("Phone") String Phone){
        try {
            boolean b = userService.SendSms(Phone);
            if(b){
                return new ResultData("200","ok","验证码发送成功");
            }
            return new ResultData("400","error","手机号已经被注册");
        }catch (Exception e){
            return new ResultData("400","error","验证码发送失败");
        }
    }

    //注册
    @PostMapping("/logon")
    public ResultData Logon(@RequestBody LogonUserDto logonUserDto){
        try {
            boolean b = userService.LogonUser(logonUserDto);
            if(b){
                return new ResultData("200","ok","注册成功");
            }
            return new ResultData("400","error","验证码错误");
        }catch (Exception e){
            return new ResultData("400","error","注册失败");
        }

    }

    //根据id查用户
    @GetMapping("/getUserbyId/{id}")
    public ResultData getUserbyId(@PathVariable("id") String id){
        SUser userByid = userService.getUserByid(id);
        return new ResultData("200","ok",userByid);
    }

    //根据id查用户name和头像
    @GetMapping("/getusernu/{id}")
    public UserUn getusernu(@PathVariable("id") String id){
        UserUn userUn = userService.getUserUn(id);
        return userUn;
    }

    //redis测试
    @GetMapping("/redis")
    public ResultData test(){
        ValueOperations<String,String> redis=redisTemplate.opsForValue();
        redis.set("longtao","666");
        return new ResultData("200","ok","redis");
    }
}
