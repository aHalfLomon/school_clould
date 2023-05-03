package talks.Pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Classname SchoolTalks
 * @Date 2023/5/3 10:59
 * @Created by wang
 */

@Data
public class SchoolTalks {
    //帖子编号；由系统生成（主键）
    private String t_id;
    //发帖人id ；记录发帖人的ID，以展示发帖人的部分信息
    private String t_uid;
    //发帖带的图片（暂定一张）
    private String t_img;
    //帖子的标题
    private String t_titile;
    //发帖内容
    private String t_source;
    //发帖日期
    private Date t_date;
    //帖子收藏数量
    private Integer t_usc_count;
    //帖子点赞数量
    private Integer t_like_count;
    //帖子状态
    private String t_status;
    //用户头像
    private String user_avatar;
    //用户名
    private String user_name;

    private List<String> comment;
    private boolean liked;
    private boolean collent;

}
