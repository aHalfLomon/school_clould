package help_sove.pojo.po;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (HelpSove)表实体类
 *
 * @author makejava
 * @since 2023-04-30 23:37:21
 */
@SuppressWarnings("serial")
@TableName("help_sove")
public class HelpSove extends Model<HelpSove> {
    //求助，反馈ID
    @TableId(value = "h_id",type = IdType.ASSIGN_UUID)
    private String hId;
    //解决时间
    @TableField(fill = FieldFill.INSERT)
    private Date hSTime;
    //解决人
    private String hSoveperson;
    //解决状态;0待解决 1解决
    private String hState;
    //解决方案
    private String hSFa;
    //反馈人id
    private String hUid;


    public String getHId() {
        return hId;
    }

    public void setHId(String hId) {
        this.hId = hId;
    }

    public Date getHSTime() {
        return hSTime;
    }

    public void setHSTime(Date hSTime) {
        this.hSTime = hSTime;
    }

    public String getHSoveperson() {
        return hSoveperson;
    }

    public void setHSoveperson(String hSoveperson) {
        this.hSoveperson = hSoveperson;
    }

    public String getHState() {
        return hState;
    }

    public void setHState(String hState) {
        this.hState = hState;
    }

    public String getHSFa() {
        return hSFa;
    }

    public void setHSFa(String hSFa) {
        this.hSFa = hSFa;
    }

    public String gethUid() {
        return hUid;
    }

    public void sethUid(String hUid) {
        this.hUid = hUid;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.hId;
    }
    }

