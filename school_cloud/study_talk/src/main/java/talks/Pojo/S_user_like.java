package talks.Pojo;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class S_user_like extends Model<School_talk> {
    //用户的点赞信息
    //点赞帖子ID
    private String t_like_tid;
    //收藏的用户ID
    private String t_like_uid;
    //点赞帖子的标题
    private String t_like_title;
    //点赞的时间
    @TableField(fill = FieldFill.INSERT)
    private Date t_like_date;


    public String getT_like_tid() {
        return t_like_tid;
    }

    public void setT_like_tid(String t_like_tid) {
        this.t_like_tid = t_like_tid;
    }

    public String getT_like_uid() {
        return t_like_uid;
    }

    public void setT_like_uid(String t_like_uid) {
        this.t_like_uid = t_like_uid;
    }

    public String getT_like_title() {
        return t_like_title;
    }

    public void setT_like_title(String t_like_title) {
        this.t_like_title = t_like_title;
    }

    public Date getT_like_date() {
        return t_like_date;
    }

    public void setT_like_date(Date t_like_date) {
        this.t_like_date = t_like_date;
    }

    @Override
    public String toString() {
        return "s_user_like{" +
                "t_like_tid='" + t_like_tid + '\'' +
                ", t_like_uid='" + t_like_uid + '\'' +
                ", t_like_title='" + t_like_title + '\'' +
                ", t_like_date=" + t_like_date +
                '}';
    }
}
