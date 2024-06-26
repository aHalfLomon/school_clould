package users.service.impl;

import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import users.config.SecurityUtil;
import users.mapper.SuserMapper;
import users.model.dto.LogonUserDto;
import users.model.dto.UpUserDto;
import users.model.dto.UserUn;
import users.model.po.SUser;
import users.service.UserService;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import com.aliyuncs.DefaultAcsClient;

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

    //更新数据库的密码(重置密码)
    @Override
    public String uppass(LogonUserDto logonUserDto) {
        //来判断有没有这个用户
        LambdaQueryWrapper<SUser> queryWrapper=new LambdaQueryWrapper<SUser>();
        queryWrapper.eq(SUser::getUserPhone,logonUserDto.getUserPhone());
        SUser phuser=suserMapper.selectOne(queryWrapper);
        if (phuser==null){
            return "用户不存在！";
        }
        //前段下发验证码
        //前端传过来的验证码
        String qSms=logonUserDto.getSms();
        //redis保存的验证码
        ValueOperations redis = redisTemplate.opsForValue();
        String hSms= (String) redis.get(logonUserDto.getUserPhone());
        //redis.set(logonUserDto.getUserPhone(),logonUserDto.getSms(),5, TimeUnit.MINUTES);//有效时间5分钟
        //从redis中拿取验证码
        if(!qSms.equals(hSms)){
            return "验证码错误，请稍后重试！";
        }
        //对密码进行编码加密，存储到数据库中
        LambdaUpdateWrapper<SUser> queryWrapper2=new LambdaUpdateWrapper<SUser>();
        String Epassword = passwordEncoder.encode(logonUserDto.getUserPassward());
        queryWrapper2.eq(SUser::getUserPhone,logonUserDto.getUserPhone())
                .set(SUser::getUserPassward,Epassword);
        //更新密码
        suserMapper.update(null,queryWrapper2);
        return "重置密码成功";
    }

    @Override
    public boolean SendSmsSet(String phone) {
        try {
            //来判断有没有这个用户
            LambdaQueryWrapper<SUser> queryWrapper=new LambdaQueryWrapper<SUser>();
            queryWrapper.eq(SUser::getUserPhone,phone);
            SUser phuser2=suserMapper.selectOne(queryWrapper);
            if (phuser2 == null){
                return false;
            }
            //直接随机产生验证码，并存入redis
            Random random=new Random();
            String sms=String.valueOf(random.nextInt(9999-1000+1)+1000);
            ValueOperations redis = redisTemplate.opsForValue();
            redis.set(phone,sms,5, TimeUnit.MINUTES);//有效时间5分钟
            //发送到手机
            sendphoneSms(phone, sms);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //注册用户
    @Override
    public boolean LogonUser(LogonUserDto logonUserDto) {
        try {
            LambdaQueryWrapper<SUser> queryWrapper=new LambdaQueryWrapper<SUser>();
            queryWrapper.eq(SUser::getUserPhone,logonUserDto.getUserPhone());
            SUser phuser=suserMapper.selectOne(queryWrapper);
            if (phuser!=null){
                return false;
            }
//        前端传过来的验证码
            String qSms=logonUserDto.getSms();
//        redis保存的验证码
            ValueOperations redis = redisTemplate.opsForValue();
            String hSms= (String) redis.get(logonUserDto.getUserPhone());

            if (!qSms.equals(hSms)){
                //验证码错误
                return false;
            }
            SUser sUser=new SUser();
            String password = passwordEncoder.encode(logonUserDto.getUserPassward());
            sUser.setUserPhone(logonUserDto.getUserPhone());
            sUser.setUserPassward(password);
            sUser.setUserName(logonUserDto.getUserName());
            suserMapper.insert(sUser);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean SendSms(String phone) {
        try {
            //判断手机号是否被注册
            LambdaQueryWrapper<SUser> queryWrapper=new LambdaQueryWrapper<SUser>();
            queryWrapper.eq(SUser::getUserPhone,phone);
            SUser phuser=suserMapper.selectOne(queryWrapper);
            if (phuser!=null){
                return false;
            }
            //生产验证码，并存入redis
            Random random=new Random();
            String sms=String.valueOf(random.nextInt(9999-1000+1)+1000);
            ValueOperations redis = redisTemplate.opsForValue();
            redis.set(phone,sms,5, TimeUnit.MINUTES);//有效时间5分钟
            //发送到手机
            sendphoneSms(phone, sms);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean UpUser(UpUserDto upUserDto) {
        try {
            SecurityUtil.XcUser user=SecurityUtil.getUser();
            SUser userx = suserMapper.selectById(user.getUserId());
            BeanUtils.copyProperties(upUserDto,userx);
            suserMapper.updateById(userx);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public SUser getUser() {
        try {
            SecurityUtil.XcUser user=SecurityUtil.getUser();
            SUser userx = suserMapper.selectById(user.getUserId());
            userx.setUserPassward(null);
            return userx;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public SUser getUserByid(String id) {
        try {
            SUser sUser = suserMapper.selectById(id);
            return sUser;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public UserUn getUserUn(String id) {
        try {
            SUser sUser = suserMapper.selectById(id);
            UserUn userUn=new UserUn();
            userUn.setUserAvatar(sUser.getUserAvatar());
            userUn.setUserName(sUser.getUserName());
            return userUn;
        }catch (Exception e){
            return null;
        }
    }

    //发送短信
    private static void sendphoneSms(String phone, String sms) {
        DefaultProfile profile = DefaultProfile.getProfile();
        IAcsClient client = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setSignName("Hi同学科技");
        request.setPhoneNumbers(phone);
        request.setTemplateCode("SMS_254291278");
        request.setTemplateParam("{\"code\":\""+ sms +"\"}");
        try {
            SendSmsResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }

    }




}
