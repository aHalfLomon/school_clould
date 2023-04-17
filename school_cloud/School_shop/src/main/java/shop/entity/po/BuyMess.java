package shop.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * (BuyMess)表实体类
 *
 * @author makejava
 * @since 2023-04-16 16:43:03
 */
@SuppressWarnings("serial")
@TableName("buy_mess")
public class BuyMess extends Model<BuyMess> {
    //订单号
    @TableId(value = "buy_id",type = IdType.ASSIGN_ID)
    private String buyId;
    //购买用户
    private String buyUid;
    //交易状态
    private Integer buyState;
    //商品图片url
    private String buyImgUrl;
    //商品名称；用于在用户页展示
    private String buyShopName;
    //商品介绍
    private String buyShopIntuoduct;
    //商品ID;用于在用户页展示
    private String buyShopId;
    //购买时间
    @TableField(fill = FieldFill.INSERT)
    private Date buyData;


    public String getBuyId() {
        return buyId;
    }

    public void setBuyId(String buyId) {
        this.buyId = buyId;
    }

    public String getBuyUid() {
        return buyUid;
    }

    public void setBuyUid(String buyUid) {
        this.buyUid = buyUid;
    }

    public Integer getBuyState() {
        return buyState;
    }

    public void setBuyState(Integer buyState) {
        this.buyState = buyState;
    }

    public String getBuyImgUrl() {
        return buyImgUrl;
    }

    public void setBuyImgUrl(String buyImgUrl) {
        this.buyImgUrl = buyImgUrl;
    }

    public String getBuyShopName() {
        return buyShopName;
    }

    public void setBuyShopName(String buyShopName) {
        this.buyShopName = buyShopName;
    }

    public String getBuyShopIntuoduct() {
        return buyShopIntuoduct;
    }

    public void setBuyShopIntuoduct(String buyShopIntuoduct) {
        this.buyShopIntuoduct = buyShopIntuoduct;
    }

    public String getBuyShopId() {
        return buyShopId;
    }

    public void setBuyShopId(String buyShopId) {
        this.buyShopId = buyShopId;
    }

    public Date getBuyData() {
        return buyData;
    }

    public void setBuyData(Date buyData) {
        this.buyData = buyData;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.buyId;
    }
    }

