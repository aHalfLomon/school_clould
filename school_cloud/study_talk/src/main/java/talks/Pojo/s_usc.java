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
public class s_usc extends Model<School_talk> {
    //用户的收藏信息
    //收藏帖子ID
    private String usc_sid;
    //收藏的用户ID
    private String usc_uid;
    //收藏的时间
    @TableField(fill = FieldFill.INSERT)
    private Date usc_data;
    //帖子的标题
    private String tk_title;

    public String getUsc_sid() {
        return usc_sid;
    }

    public void setUsc_sid(String usc_sid) {
        this.usc_sid = usc_sid;
    }

    public String getUsc_uid() {
        return usc_uid;
    }

    public void setUsc_uid(String usc_uid) {
        this.usc_uid = usc_uid;
    }

    public Date getUsc_data() {
        return usc_data;
    }

    public void setUsc_data(Date usc_data) {
        this.usc_data = usc_data;
    }

    public String getTk_title() {
        return tk_title;
    }

    public void setTk_title(String tk_title) {
        this.tk_title = tk_title;
    }

    @Override
    public String toString() {
        return "s_usc{" +
                "usc_sid='" + usc_sid + '\'' +
                ", usc_uid='" + usc_uid + '\'' +
                ", usc_data=" + usc_data +
                ", tk_title='" + tk_title + '\'' +
                '}';
    }
}
