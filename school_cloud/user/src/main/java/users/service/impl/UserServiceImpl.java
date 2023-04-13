package users.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import users.config.SecurityUtil;
import users.mapper.SuserMapper;
import users.model.dto.LogonUserDto;
import users.model.po.SUser;
import users.service.UserService;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @ClassName UserServiceImpl
 * @Author 龙涛05664416459
 * @Date 2023/4/12 19:14
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SuserMapper suserMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Resource
    PasswordEncoder passwordEncoder;

    @Override
    public boolean LogonUser(LogonUserDto logonUserDto) {

//        前端传过来的验证码
        String qSms=logonUserDto.getSms();
//        redis保存的验证码
        ValueOperations redis = redisTemplate.opsForValue();
        String hSms= (String) redis.get(logonUserDto.getUserPhone());

//        if (!qSms.equals(hSms)){
//            //验证码错误
//            return false;
//        }
        SUser sUser=new SUser();
        String password = passwordEncoder.encode(logonUserDto.getUserPassward());
        sUser.setUserPhone(logonUserDto.getUserPhone());
        sUser.setUserPassward(password);
        sUser.setUserName(logonUserDto.getUserName());
        suserMapper.insert(sUser);
        return true;
    }

    @Override
    public boolean SendSms(String phone) {
        //判断手机号是否被注册

        //发送到手机

        //生产验证码，并存入redis
        Random random=new Random();
        String sms=String.valueOf(random.nextInt(9999-1000+1)+1000);
        ValueOperations redis = redisTemplate.opsForValue();
        redis.set(phone,sms,5, TimeUnit.MINUTES);//有效时间5分钟
        return true;
    }

    @Override
    public boolean UpUser(SUser sUser) {
        SecurityUtil.XcUser user=SecurityUtil.getUser();
//        sUser.setUserUpdateTime();
        return false;
    }
}
