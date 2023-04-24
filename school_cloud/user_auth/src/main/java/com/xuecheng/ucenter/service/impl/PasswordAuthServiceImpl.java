package com.xuecheng.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.xuecheng.ucenter.feignclient.CheckCodeClient;
import com.xuecheng.ucenter.mapper.UserMapper;

import com.xuecheng.ucenter.model.dto.AuthParamsDto;
import com.xuecheng.ucenter.model.dto.LoginUserDto;
import com.xuecheng.ucenter.model.po.SUser;
import com.xuecheng.ucenter.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

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

 @Autowired
 RedisTemplate redisTemplate;

 @Override
 public LoginUserDto execute(AuthParamsDto authParamsDto) {
  //账号
  String cellphone = authParamsDto.getCellphone();
  //redis
  boolean exists = redisTemplate.hasKey("token:"+cellphone);
  ValueOperations redis = redisTemplate.opsForValue();
  String flag = (String) redis.get("flag");
  if (flag.equals("0")){//第一次
   redis.set("flag","1");
   if (exists){//已经登录
    // 将token存入reids中的过期
    String s = (String) redis.get("token:" + cellphone);
    redis.set("guoqi:"+s,cellphone,2, TimeUnit.HOURS);
   }
  }else{
   redis.set("flag","0");
  }

  //账号是否存在
  //根据username账号查询数据库
  SUser sUser = userMapper.selectOne(new LambdaQueryWrapper<SUser>().eq(SUser::getUserPhone, cellphone));

  //查询到用户不存在，要返回null即可，spring security框架抛出异常用户不存在
  if(sUser==null){
   throw new RuntimeException("账号不存在");
  }

  //验证密码是否正确
  //如果查到了用户拿到正确的密码
  String passwordDb = sUser.getUserPassward();
//  //拿 到用户输入的密码
  String passwordForm = authParamsDto.getPassword();
  //校验密码
  boolean matches = passwordEncoder.matches(passwordForm, passwordDb);

  if(!matches){
   throw new RuntimeException("账号或密码错误");
  }

  LoginUserDto dtouser=new LoginUserDto();
  dtouser.setUserId(sUser.getUserId());
  dtouser.setUserPhone(sUser.getUserPhone());
  return dtouser;
 }

}
