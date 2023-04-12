package users.config;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Mr.M
 * @version 1.0
 * @description TODO
 * @date 2023/2/24 11:26
 */
@Slf4j
public class SecurityUtil {

    public static XcUser getUser() {
        try {
            //拿 到当前用户身份
            Object principalObj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principalObj instanceof String) {
                //取出用户身份信息
                String principal = principalObj.toString();
                //将json转成对象
                XcUser user = JSON.parseObject(principal, XcUser.class);
                return user;
            }
        } catch (Exception e) {
            log.error("获取当前登录用户身份出错:{}", e.getMessage());
            e.printStackTrace();
        }

        return null;
    }


    @Data
    public static class XcUser implements Serializable {

        private static final long serialVersionUID = 1L;

        private String userId;
        //用户昵称
        private String userName;
        //用户类别；包括 管理员 学生 校媒体
        private String userType;
        //用户头像；255字符 图床的url
        private String userAvatar;
        //用户邮箱
        private String userEmail;
        //用户手机
        private String userPhone;
        //用户密码
        private String userPassward;
        //用户自我介绍
        private String userIntroduct;
        //用户注册时间
        private Date userCreateTime;
        //用户状态1正常 2 异常
        private String userStatus;
        //用户学校
        private String userSchool;
        //用户性别
        private String userSex;
        //用户年龄
        private Integer userAge;
        //用户资料更新时间
        private Date userUpdateTime;


    }


}
