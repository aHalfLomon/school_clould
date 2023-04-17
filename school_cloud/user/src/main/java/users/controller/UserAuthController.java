package users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import users.model.po.SUser;
import users.model.utilsDto.ResultData;
import users.service.UserService;

/**
 * @Description TODO
 * @ClassName UserAuthController
 * @Author 龙涛05664416459
 * @Date 2023/4/13 19:26
 **/
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserAuthController {

    @Autowired
    UserService userService;

    //退出
    @GetMapping("/logout")
    public ResultData Logout(){
        return new ResultData("200","ok","logout");
    }

    //修改用户信息
    @PostMapping("/upuser")
    public ResultData upUser(@RequestBody SUser sUser){
        return new ResultData("200","ok","upuser");
    }

}
