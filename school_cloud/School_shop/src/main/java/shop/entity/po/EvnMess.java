package shop.entity.po;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (EvnMess)表实体类
 *
 * @author makejava
 * @since 2023-04-29 18:51:13
 */
@SuppressWarnings("serial")
@TableName("evn_mess")
public class EvnMess extends Model<EvnMess> {
    //事件/新闻ID
    @TableId(value = "evn_id",type = IdType.ASSIGN_ID)
    private String evnId;
    //事件/新闻简介
    private String evnTitle;
    //事件/新闻I图片
    private String evnImg;
    //事件/新闻时间
    @TableField(fill = FieldFill.INSERT)
    private Date evnData;

    private String evnTest;


    public String getEvnId() {
        return evnId;
    }

    public void setEvnId(String evnId) {
        this.evnId = evnId;
    }

    public String getEvnTitle() {
        return evnTitle;
    }

    public void setEvnTitle(String evnTitle) {
        this.evnTitle = evnTitle;
    }

    public String getEvnImg() {
        return evnImg;
    }

    public void setEvnImg(String evnImg) {
        this.evnImg = evnImg;
    }

    public Date getEvnData() {
        return evnData;
    }

    public void setEvnData(Date evnData) {
        this.evnData = evnData;
    }

    public String getEvnTest() {
        return evnTest;
    }

    public void setEvnTest(String evnTest) {
        this.evnTest = evnTest;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.evnId;
    }
    }

