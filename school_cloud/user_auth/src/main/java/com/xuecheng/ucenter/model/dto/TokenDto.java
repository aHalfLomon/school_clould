package com.xuecheng.ucenter.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @ClassName TokenDto
 * @Author 龙涛05664416459
 * @Date 2023/4/22 23:56
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {

    private String access_token;
    private String token_type;
    private String refresh_token;
    private String expires_in;
    private String scope;
    private String jti;
}
