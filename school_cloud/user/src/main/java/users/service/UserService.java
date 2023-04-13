package users.service;

import users.model.dto.LogonUserDto;
import users.model.po.SUser;

import java.util.List;

public interface UserService {

    List<SUser> getAllUsers();

    //注册
    boolean LogonUser(LogonUserDto logonUserDto);
}
