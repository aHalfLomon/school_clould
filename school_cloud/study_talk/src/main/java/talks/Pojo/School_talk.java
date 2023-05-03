package talks.Pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@TableName("s_t")
public class School_talk extends Model<School_talk> {

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
    @TableField(fill = FieldFill.INSERT)
    private Date t_date;
    //帖子收藏数量
    private Integer t_usc_count;
    //帖子点赞数量
    private Integer t_like_count;
    //帖子状态
    private String t_status;

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getT_uid() {
        return t_uid;
    }

    public void setT_uid(String t_uid) {
        this.t_uid = t_uid;
    }

    public String getT_img() {
        return t_img;
    }

    public void setT_img(String t_img) {
        this.t_img = t_img;
    }

    public String getT_source() {
        return t_source;
    }

    public void setT_source(String t_source) {
        this.t_source = t_source;
    }

    public Date getT_date() {
        return t_date;
    }

    public void setT_date(Date t_date) {
        this.t_date = t_date;
    }

    public Integer getT_usc_count() {
        return t_usc_count;
    }

    public void setT_usc_count(Integer t_usc_count) {
        this.t_usc_count = t_usc_count;
    }

    public Integer getT_like_count() {
        return t_like_count;
    }

    public void setT_like_count(Integer t_like_count) {
        this.t_like_count = t_like_count;
    }

    public String getT_status() {
        return t_status;
    }

    public void setT_status(String t_status) {
        this.t_status = t_status;
    }

    public String getT_titile() {
        return t_titile;
    }

    public void setT_titile(String t_titile) {
        this.t_titile = t_titile;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.t_id;
    }
    }

