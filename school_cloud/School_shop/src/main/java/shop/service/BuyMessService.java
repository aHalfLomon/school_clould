package shop.service;

import shop.entity.po.BuyMess;
import shop.entity.po.ShopMess;

import java.util.List;

public interface BuyMessService {

    //查看我购买的商品
    public List<BuyMess> getBuyShop();

    //查看我的购物车
    public List<BuyMess> getcar();

    //新增到我的购买
    public void buyShop(ShopMess shopMess,String url);

    //放入购物车
    void inShopCar(ShopMess shopMess,String url);

    //在购物车中购买
    void buyShopinCar(String shopid);
}
