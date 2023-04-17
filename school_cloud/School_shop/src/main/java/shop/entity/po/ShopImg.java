package shop.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (ShopImg)表实体类
 *
 * @author makejava
 * @since 2023-04-16 16:41:04
 */
@SuppressWarnings("serial")
@TableName("shop_img")
public class ShopImg extends Model<ShopImg> {
    //图片url
    private String sImgUrl;
    //图片所属商品ID
    private String sImgSid;
    //nt 在商品详情页展示的顺序
    private Integer sImg;


    public String getSImgUrl() {
        return sImgUrl;
    }

    public void setSImgUrl(String sImgUrl) {
        this.sImgUrl = sImgUrl;
    }

    public String getSImgSid() {
        return sImgSid;
    }

    public void setSImgSid(String sImgSid) {
        this.sImgSid = sImgSid;
    }

    public Integer getSImg() {
        return sImg;
    }

    public void setSImg(Integer sImg) {
        this.sImg = sImg;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.sImgSid;
    }
    }

