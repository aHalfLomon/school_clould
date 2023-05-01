package help_sove.pojo.po;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (HelpMess)表实体类
 *
 * @author makejava
 * @since 2023-04-30 23:36:53
 */
@SuppressWarnings("serial")
@TableName("help_mess")
public class HelpMess extends Model<HelpMess> {
    //求助，反馈ID
    @TableId(value = "h_id",type = IdType.ASSIGN_UUID)
    private String hId;
    //求助，反馈人;展示发起人的部分基本信息
    private String hUid;
    //求助，反馈内容
    private String hSource;
    //反馈的地点
    private String hLocation;
    //解决状态:0待解决 1解决
    @TableField(fill = FieldFill.INSERT)
    private String hState;
    //求助、反馈时间
    @TableField(fill = FieldFill.INSERT)
    private Date hData;


    public String getHId() {
        return hId;
    }

    public void setHId(String hId) {
        this.hId = hId;
    }

    public String getHUid() {
        return hUid;
    }

    public void setHUid(String hUid) {
        this.hUid = hUid;
    }

    public String getHSource() {
        return hSource;
    }

    public void setHSource(String hSource) {
        this.hSource = hSource;
    }

    public String getHLocation() {
        return hLocation;
    }

    public void setHLocation(String hLocation) {
        this.hLocation = hLocation;
    }

    public String getHState() {
        return hState;
    }

    public void setHState(String hState) {
        this.hState = hState;
    }

    public Date getHData() {
        return hData;
    }

    public void setHData(Date hData) {
        this.hData = hData;
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

