package talks.Pojo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (STk)表实体类
 *
 * @author makejava
 * @since 2023-04-05 16:47:26
 */
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
public class Talk_talks extends Model<Talk_talks> {
    //评论的ID
    private String tk_id;
    //由此来展示评论用户的部分信息
    private String tk_uid;
    //评论帖子ID
    private String tk_tid;
    //评论内容
    private String tk_source;
    //发表评论的时间
    private Date tk_data;

    public String getTk_id() {
        return tk_id;
    }

    public String getTk_uid() {
        return tk_uid;
    }

    public String getTk_tid() {
        return tk_tid;
    }

    public String getTk_source() {
        return tk_source;
    }

    public Date getTk_data() {
        return tk_data;
    }

    public void setTk_id(String tk_id) {
        this.tk_id = tk_id;
    }

    public void setTk_uid(String tk_uid) {
        this.tk_uid = tk_uid;
    }

    public void setTk_tid(String tk_tid) {
        this.tk_tid = tk_tid;
    }

    public void setTk_source(String tk_source) {
        this.tk_source = tk_source;
    }

    public void setTk_data(Date tk_data) {
        this.tk_data = tk_data;
    }

    @Override
    protected Serializable pkVal() {
        return this.tk_id;
    }
    }

