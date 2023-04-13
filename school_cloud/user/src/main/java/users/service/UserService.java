package users.service;

import users.model.dto.LogonUserDto;
import users.model.po.SUser;

import java.util.List;

public interface UserService {

    //注册
    boolean LogonUser(LogonUserDto logonUserDto);

    //发送验证码
    boolean SendSms(String phone);

    //修改用户信息
    boolean UpUser(SUser sUser);
}
