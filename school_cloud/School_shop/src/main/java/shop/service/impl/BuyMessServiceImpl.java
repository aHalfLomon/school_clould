package shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.config.SecurityUtil;
import shop.entity.po.BuyMess;
import shop.entity.po.ShopMess;
import shop.mapper.BuyMessDao;
import shop.service.BuyMessService;

import java.util.List;

/**
 * @Description TODO
 * @ClassName BuyMessServiceImpl
 * @Author 龙涛05664416459
 * @Date 2023/4/18 10:56
 **/
@Service
public class BuyMessServiceImpl implements BuyMessService {

    @Autowired
    BuyMessDao buyMessDao;

    @Override
    public List<BuyMess> getBuyShop() {
        //将shopUid赋值
        String userid= SecurityUtil.getUser().getUserId();
        LambdaQueryWrapper<BuyMess> lambdaQueryWrapper=new LambdaQueryWrapper<BuyMess>()
                .eq(BuyMess::getBuyUid,userid)
                .eq(BuyMess::getBuyState,2);
        List<BuyMess> buyMesses = buyMessDao.selectList(lambdaQueryWrapper);

        return buyMesses;
    }

    @Override
    public List<BuyMess> getcar() {
        String userid= SecurityUtil.getUser().getUserId();
        LambdaQueryWrapper<BuyMess> lambdaQueryWrapper=new LambdaQueryWrapper<BuyMess>()
                .eq(BuyMess::getBuyUid,userid)
                .eq(BuyMess::getBuyState,1);
        List<BuyMess> buyMesses = buyMessDao.selectList(lambdaQueryWrapper);

        return buyMesses;
    }

    //购买商品
    @Override
    public void buyShop(ShopMess shopMess,String url) {
        BuyMess buyMess=new BuyMess();
        buyMess.setBuyUid(SecurityUtil.getUser().getUserId());
        buyMess.setBuyState(2);
        buyMess.setBuyImgUrl(url);
        buyMess.setBuyShopName(shopMess.getShopName());
        buyMess.setBuyShopIntuoduct(shopMess.getShopIntuoduct());
        buyMess.setBuyShopId(shopMess.getShopId());
        buyMessDao.insert(buyMess);
    }

    //加入购物车
    @Override
    public void inShopCar(ShopMess shopMess,String url) {
        BuyMess buyMess=new BuyMess();
        buyMess.setBuyUid(SecurityUtil.getUser().getUserId());
        buyMess.setBuyState(1);
        buyMess.setBuyImgUrl(url);
        buyMess.setBuyShopName(shopMess.getShopName());
        buyMess.setBuyShopIntuoduct(shopMess.getShopIntuoduct());
        buyMess.setBuyShopId(shopMess.getShopId());
        buyMessDao.insert(buyMess);
    }

    //在购物车中购买
    @Override
    public void buyShopinCar(String shopid) {
        LambdaQueryWrapper<BuyMess> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(BuyMess::getBuyShopId,shopid);
        BuyMess buyMess = buyMessDao.selectOne(queryWrapper);
        buyMess.setBuyState(2);
        buyMessDao.updateById(buyMess);
    }

}
