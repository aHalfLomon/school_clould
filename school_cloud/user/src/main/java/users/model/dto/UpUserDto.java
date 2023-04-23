package users.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @ClassName UpUserDto
 * @Author 龙涛05664416459
 * @Date 2023/4/21 21:02
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpUserDto {
    private String userName;
    //用户邮箱
    private String userEmail;
//    用户头像
    private String userAvatar;
    //用户学校
    private String userSchool;
    //用户自我介绍
    private String userIntroduct;
//    用户性别
    private String userSex;
    //用户年龄
    private Integer userAge;
}
