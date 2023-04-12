package help_sove.pojo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (HlepMess)实体类
 *
 * @author makejava
 * @since 2023-04-11 11:37:11
 */
@AllArgsConstructor
@NoArgsConstructor
public class HlepMess extends Model<HlepMess> {

    /**
     * 求助，反馈ID
     */
    private String h_id;
    /**
     * 求助，反馈人;展示发起人的部分基本信息
     */
    private String h_uid;
    /**
     * 求助，反馈内容
     */
    private String h_source;
    /**
     * 解决状态:0待解决 1解决
     */
    private String h_state;
    /**
     * 求助、反馈时间
     */
    private Date h_data;


    public String getH_id() {
        return h_id;
    }

    public void setH_id(String h_id) {
        this.h_id = h_id;
    }

    public String getH_uid() {
        return h_uid;
    }

    public void setH_uid(String h_uid) {
        this.h_uid = h_uid;
    }

    public String getH_source() {
        return h_source;
    }

    public void setH_source(String h_source) {
        this.h_source = h_source;
    }

    public String getH_state() {
        return h_state;
    }

    public void setH_state(String h_state) {
        this.h_state = h_state;
    }

    public Date getH_data() {
        return h_data;
    }

    public void setH_data(Date h_data) {
        this.h_data = h_data;
    }

    @Override
    protected Serializable pkVal() {
        return this.h_id;
    }

}

