package talks.Pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @ClassName SuserDto
 * @Author 龙涛05664416459
 * @Date 2023/5/2 23:11
 **/
@Data
public class SuserDto {
    //收藏帖子ID
    private String usc_sid;
    //收藏的用户ID
    private String usc_uid;
    //收藏的时间
    private Date usc_data;
    //帖子的标题
    private String tk_title;

    private String user_avatar;

    private String user_name;
}
