package talks.Pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class Stu_talks {
    private String tk_id;
    //由此来展示评论用户的部分信息
    private String tk_uid;
    //评论帖子ID
    private String tk_tid;
    //评论内容
    private String tk_source;
    //发表评论的时间
    @TableField(fill = FieldFill.INSERT)
    private Date tk_data;

    private String user_avatar;

    private String user_name;
}
