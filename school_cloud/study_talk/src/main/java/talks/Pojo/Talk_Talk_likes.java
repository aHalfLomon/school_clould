package talks.Pojo;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class Talk_Talk_likes extends Model<Talk_talks> {
    //帖子ID
    private String like_sid;
    //点赞用户ID
    private String like_uid;
    //点赞时间;可用来按时间排序，来展示用户的点赞帖子
    @TableField(fill = FieldFill.INSERT)
    private Date like_data;

    public String getLike_sid() {
        return like_sid;
    }

    public void setLike_sid(String like_sid) {
        this.like_sid = like_sid;
    }

    public String getLike_uid() {
        return like_uid;
    }

    public void setLike_uid(String like_uid) {
        this.like_uid = like_uid;
    }

    public Date getLike_data() {
        return like_data;
    }

    public void setLike_data(Date like_data) {
        this.like_data = like_data;
    }
    @Override
    protected Serializable pkVal() {
        return this.like_sid;
    }
}
