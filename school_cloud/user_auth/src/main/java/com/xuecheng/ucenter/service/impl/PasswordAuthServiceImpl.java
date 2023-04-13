package com.xuecheng.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.xuecheng.ucenter.feignclient.CheckCodeClient;
import com.xuecheng.ucenter.mapper.UserMapper;

import com.xuecheng.ucenter.model.dto.AuthParamsDto;
import com.xuecheng.ucenter.model.po.SUser;
import com.xuecheng.ucenter.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Mr.M
 * @version 1.0
 * @description 账号名密码方式
 * @date 2023/2/24 11:56
 */
@Service("password_authservice")
public class PasswordAuthServiceImpl implements AuthService {

 @Autowired
 UserMapper userMapper;

 @Autowired
 PasswordEncoder passwordEncoder;

 @Override
 public SUser execute(AuthParamsDto authParamsDto) {
  //账号
  String cellphone = authParamsDto.getCellphone();

  //账号是否存在
  //根据username账号查询数据库
  SUser sUser = userMapper.selectOne(new LambdaQueryWrapper<SUser>().eq(SUser::getUserPhone, cellphone));

  //查询到用户不存在，要返回null即可，spring security框架抛出异常用户不存在
  if(sUser==null){
   throw new RuntimeException("账号不存在xxxx");
  }

  //验证密码是否正确
  //如果查到了用户拿到正确的密码
  String passwordDb = sUser.getUserPassward();
//  //拿 到用户输入的密码
  String passwordForm = authParamsDto.getPassword();
  //校验密码
  boolean matches = passwordEncoder.matches(passwordForm, passwordDb);
//  System.out.println(passwordDb+" "+passwordForm);
  if(!matches){
   throw new RuntimeException("账号或密码错误xxx");
  }
//  if(!passwordDb.equals(passwordForm)){
//   throw new RuntimeException("账号或密码错误");
//  }

  return sUser;
 }

}
