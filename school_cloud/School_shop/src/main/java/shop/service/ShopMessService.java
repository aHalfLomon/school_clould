package shop.service;

import shop.entity.po.ShopMess;

import java.util.List;

/**
 * @Description TODO
 * @ClassName ShopService
 * @Author 龙涛05664416459
 * @Date 2023/4/16 16:49
 **/
public interface ShopMessService {

    //查询所有商品，分页
    List<ShopMess> getAllShop();

    //发布商品
    void upMyShop(ShopMess shopMess);

    //删除商品
    void deleteMyShop(String shopId);

    //查询我发布的商品
    List<ShopMess> getMyUpShop();


}
