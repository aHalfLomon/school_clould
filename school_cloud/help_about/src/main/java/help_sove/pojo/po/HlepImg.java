package help_sove.pojo.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (HlepImg)表实体类
 *
 * @author makejava
 * @since 2023-04-30 23:37:40
 */
@SuppressWarnings("serial")
@TableName("hlep_img")
public class HlepImg extends Model<HlepImg> {
    //图片url 
    private String hImgUrl;
    //图片所属求助反馈ID
    private String hImgSid;
    //图片编号 ;在求助，反馈详情页展示的顺序
    @TableField(fill = FieldFill.INSERT)
    private Integer hImg;


    public String getHImgUrl() {
        return hImgUrl;
    }

    public void setHImgUrl(String hImgUrl) {
        this.hImgUrl = hImgUrl;
    }

    public String getHImgSid() {
        return hImgSid;
    }

    public void setHImgSid(String hImgSid) {
        this.hImgSid = hImgSid;
    }

    public Integer getHImg() {
        return hImg;
    }

    public void setHImg(Integer hImg) {
        this.hImg = hImg;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.hImgUrl;
    }
    }

