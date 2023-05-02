package users.model.po;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * (SUser)表实体类
 *
 * @author makejava
 * @since 2023-04-03 20:05:51
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("s_user")
public class SUser extends Model<SUser> {
    //用户ID；系统生成 (主键)
    @TableId(value = "user_id",type = IdType.ASSIGN_UUID)
    private String userId;
    //用户昵称
    private String userName;
    //用户类别；包括 管理员 学生 校媒体
    @TableField(fill = FieldFill.INSERT)
    private String userType;
    //用户头像；255字符 图床的url
    @TableField(fill = FieldFill.INSERT)
    private String userAvatar;
    //用户邮箱DD
    private String userEmail;
    //用户手机
    private String userPhone;
    //用户密码
    private String userPassward;
    //用户自我介绍
    @TableField(fill = FieldFill.INSERT)
    private String userIntroduct;
    //用户注册时间
    @TableField(fill = FieldFill.INSERT)
    private Date userCreateTime;
    //用户状态1正常 2 异常
    @TableField(fill = FieldFill.INSERT)
    private String userStatus;
    //用户学校
    private String userSchool;
    //用户性别
    private String userSex;
    //用户年龄
    private Integer userAge;
    //用户资料更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date userUpdateTime;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassward() {
        return userPassward;
    }

    public void setUserPassward(String userPassward) {
        this.userPassward = userPassward;
    }

    public String getUserIntroduct() {
        return userIntroduct;
    }

    public void setUserIntroduct(String userIntroduct) {
        this.userIntroduct = userIntroduct;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Date getUserUpdateTime() {
        return userUpdateTime;
    }

    public void setUserUpdateTime(Date userUpdateTime) {
        this.userUpdateTime = userUpdateTime;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
    }

