package shop.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @ClassName ShopDto
 * @Author 龙涛05664416459
 * @Date 2023/4/25 21:13
 **/
@Data
public class ShopDto {
    //商品名字
    private String shopName;
    //商品介绍
    private String shopIntuoduct;
    //商品价格
    private Double shopPrice;
    //图片
    private String[] url;
}
