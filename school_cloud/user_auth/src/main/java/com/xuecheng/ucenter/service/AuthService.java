package com.xuecheng.ucenter.service;

import com.xuecheng.ucenter.model.dto.AuthParamsDto;
import com.xuecheng.ucenter.model.dto.LoginUserDto;
import com.xuecheng.ucenter.model.po.SUser;


public interface AuthService {

 LoginUserDto execute(AuthParamsDto authParamsDto);


}
