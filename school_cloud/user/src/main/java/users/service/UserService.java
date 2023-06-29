package users.service;

import users.model.dto.LogonUserDto;
import users.model.dto.UpUserDto;
import users.model.dto.UserUn;
import users.model.po.SUser;

import java.util.List;

public interface UserService {

    //注册
    boolean LogonUser(LogonUserDto logonUserDto);

    //发送验证码
    boolean SendSms(String phone);

    //修改用户信息
    boolean UpUser(UpUserDto upUserDto);

    //获取用户信息
    SUser getUser();

    //根据id查用户信息
    SUser getUserByid(String id);

    //根据id查用户name和头像
    UserUn getUserUn(String id);

    String uppass(LogonUserDto logonUserDto);
    boolean SendSmsSet(String phone);
}
