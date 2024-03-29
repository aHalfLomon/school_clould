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
    List<GetShop> getMyUpShop();

    //通过id查商品信息
    ShopMess getOneShop(String shopId);

    //通过name查商品信息
    List<GetShop> getOneShopbyName(String name);

    //直接购买商品
    void buyShop(String shopid);

    //加入购物车
    void incar(String shopid);

    ////查询分类商品
    List<GetShop> classShop(String className);
}
