package shop.service;

import shop.entity.po.BuyMess;
import shop.entity.po.ShopMess;

import java.util.List;

public interface BuyMessService {

    //查看我购买的商品
    public List<BuyMess> getBuyShop();

    //新增到我的购买
    public void buyShop(ShopMess shopMess,String url);
}
