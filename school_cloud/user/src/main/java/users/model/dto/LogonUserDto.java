package users.model.dto;

import lombok.Data;

/**
 * @Description TODO
 * @ClassName LogonUserDto
 * @Author 龙涛05664416459
 * @Date 2023/4/12 20:59
 **/
@Data
public class LogonUserDto {

    private String userPhone;

    private String userPassward;

    private String userName;

    private String sms;
}
