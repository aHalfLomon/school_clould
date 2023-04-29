package shop.service;

import shop.entity.dto.GetShop;
import shop.entity.dto.ShopDto;
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
    List<GetShop>  getAllShop(int page);

    //发布商品
    void upMyShop(ShopDto shopDto);

    //删除商品
    void deleteMyShop(String shopId);

    //查询我发布的商品
    List<ShopMess> getMyUpShop();

    //通过id查商品信息
    ShopMess getOneShop(String shopId);

    //通过name查商品信息
    ShopMess getOneShopbyName(String name);

    void buyShop(String shopid);

}
