package com.xuecheng.ucenter.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @ClassName LoginUserDto
 * @Author 龙涛05664416459
 * @Date 2023/4/22 17:05
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDto {
    private String userId;
    private String userPhone;
}
