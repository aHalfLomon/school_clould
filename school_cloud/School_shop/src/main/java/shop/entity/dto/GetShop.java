package shop.entity.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @ClassName GetShop
 * @Author 龙涛05664416459
 * @Date 2023/4/28 22:50
 **/
@Data
public class GetShop {
    //商品ID
    private String shopId;
    //商品名称
    private String shopName;
    //商品介绍
    private String shopIntuoduct;
    //商品价格
    private Double shopPrice;
    //发售用户ID
    private String shopUid;
    //是否被购买
    private Integer shopBuy;
    //发售时间
    private Date shopData;
    //发售用户名字
    private String userName;
    //发售用户头像
    private String userUrl;
    //商品图片
    private List<String> urlList;
}
