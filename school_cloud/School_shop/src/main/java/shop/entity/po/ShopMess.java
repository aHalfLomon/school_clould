package shop.entity.po;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (ShopMess)表实体类
 *
 * @author makejava
 * @since 2023-04-28 23:51:52
 */
@SuppressWarnings("serial")
@TableName("shop_mess")
public class ShopMess extends Model<ShopMess> {
    //商品ID
    @TableId(value = "shop_id",type = IdType.ASSIGN_ID)
    private String shopId;
    //商品名称
    private String shopName;
    //商品介绍
    private String shopIntuoduct;
    //商品价格
    private Double shopPrice;
    //发售用户ID
    private String shopUid;
    //是否被购买 1为购买，0为未购买
    @TableField(fill = FieldFill.INSERT)
    private Integer shopBuy;
    //发售时间
    @TableField(fill = FieldFill.INSERT)
    private Date shopData;
    //分类
    private String shopClass;


    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopIntuoduct() {
        return shopIntuoduct;
    }

    public void setShopIntuoduct(String shopIntuoduct) {
        this.shopIntuoduct = shopIntuoduct;
    }

    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getShopUid() {
        return shopUid;
    }

    public void setShopUid(String shopUid) {
        this.shopUid = shopUid;
    }

    public Integer getShopBuy() {
        return shopBuy;
    }

    public void setShopBuy(Integer shopBuy) {
        this.shopBuy = shopBuy;
    }

    public Date getShopData() {
        return shopData;
    }

    public void setShopData(Date shopData) {
        this.shopData = shopData;
    }

    public String getShopClass() {
        return shopClass;
    }

    public void setShopClass(String shopClass) {
        this.shopClass = shopClass;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.shopId;
    }
    }

