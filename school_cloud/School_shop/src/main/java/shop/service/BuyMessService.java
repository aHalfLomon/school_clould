package shop.service;

import shop.entity.po.BuyMess;

import java.util.List;

public interface BuyMessService {

    //查看我购买的商品
    public List<BuyMess> getBuyShop();

    //
}
