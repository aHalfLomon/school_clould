package com.xuecheng.ucenter.service.impl;

import com.alibaba.fastjson.JSON;
import com.xuecheng.ucenter.mapper.UserMapper;
import com.xuecheng.ucenter.model.dto.AuthParamsDto;
import com.xuecheng.ucenter.model.po.SUser;
import com.xuecheng.ucenter.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @ClassName UserServiceImpl
 * @Author 龙涛05664416459
 * @Date 2023/4/2 18:52
 **/
@Component
@Slf4j
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //将传入的json转成AuthParamDto
        AuthParamsDto authParamsDto=null;
        try {
            authParamsDto=JSON.parseObject(s,AuthParamsDto.class);
        }catch (Exception e){
            throw new RuntimeException("请求认证参数不符合要求");
        }
        //认证类型
        String authType=authParamsDto.getAuthType();

        //根据认证类型从spring容器取出指定的bean
        String beanName=authType+"_authservice";
        AuthService authService = applicationContext.getBean(beanName, AuthService.class);
        //调用
        SUser execute = authService.execute(authParamsDto);
        //

        UserDetails userPrincipal = getUserPrincipal(execute);
        return userPrincipal;
    }

    public UserDetails getUserPrincipal(SUser xcUser){
        String password = xcUser.getUserPassward();
        //权限
        String[] authorities=  {"test"};
        xcUser.setUserPassward(null);
        //将用户信息转json
        String userJson = JSON.toJSONString(xcUser);
        UserDetails userDetails = User.withUsername(userJson).password(password).authorities(authorities).build();
        return  userDetails;
    }

}
