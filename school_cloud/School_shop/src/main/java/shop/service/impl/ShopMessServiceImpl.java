package shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.config.SecurityUtil;
import shop.entity.dto.GetShop;
import shop.entity.dto.ShopDto;
import shop.entity.po.BuyMess;
import shop.entity.po.ShopMess;
import shop.mapper.ShopMessDao;
import shop.service.BuyMessService;
import shop.service.ImageService;
import shop.service.ShopMessService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Description TODO
 * @ClassName ShopServiceImpl
 * @Author 龙涛05664416459
 * @Date 2023/4/16 16:49
 **/
@Service
public class ShopMessServiceImpl implements ShopMessService {

    @Autowired
    ShopMessDao shopMessDao;

    @Autowired
    BuyMessService buyMessService;

    @Autowired
    ImageService imageService;

    @Override
    public List<GetShop> getAllShop(int p) {
        //分页
        Page<ShopMess> page= new Page<>(p,4);
        page=shopMessDao.selectPage(page,null);
        LambdaQueryWrapper<ShopMess> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        List<ShopMess> list=page.getRecords();
        List<GetShop> getShops=new ArrayList<>();
        for (ShopMess shopMess:list){
            GetShop getShop=new GetShop();
            getShop.setShopId(shopMess.getShopId());
            getShop.setShopName(shopMess.getShopName());
            getShop.setShopIntuoduct(shopMess.getShopIntuoduct());
            getShop.setShopPrice(shopMess.getShopPrice());
            getShop.setShopUid(shopMess.getShopUid());
            getShop.setShopBuy(shopMess.getShopBuy());
            getShop.setShopData(shopMess.getShopData());
            getShop.setUserName("null");
            getShop.setUserUrl("null");
            getShop.setUrlList(imageService.getList(shopMess.getShopId()));
            getShops.add(getShop);
        }
        return getShops;
    }

    @Override
    public void upMyShop(ShopDto shopDto) {
        //将shopUid赋值
        String userid=SecurityUtil.getUser().getUserId();

        ShopMess shopMess=new ShopMess();
        shopMess.setShopId(UUID.randomUUID().toString().replaceAll("-",""));
        shopMess.setShopName(shopDto.getShopName());
        shopMess.setShopIntuoduct(shopDto.getShopIntuoduct());
        shopMess.setShopPrice(shopDto.getShopPrice());
        shopMess.setShopUid(userid);
        shopMess.setShopBuy(0);
        int i=0;
        for (String u:shopDto.getUrl()){
            imageService.addImg(u,shopMess.getShopId(),i);
            i++;
        }

        shopMessDao.insert(shopMess);
    }

    @Override
    public void deleteMyShop(String shopId) {
        shopMessDao.deleteById(shopId);
    }

    @Override
    public List<ShopMess> getMyUpShop() {
        SecurityUtil.XcUser user=SecurityUtil.getUser();
        LambdaQueryWrapper<ShopMess> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(ShopMess::getShopId,user.getUserId());
        List<ShopMess> list = shopMessDao.selectList(queryWrapper);
        return list;
    }

    @Override
    public ShopMess getOneShop(String shopId) {
        ShopMess shopMess=shopMessDao.selectById(shopId);
        return shopMess;
    }

    @Override
    public ShopMess getOneShopbyName(String name) {
        LambdaQueryWrapper<ShopMess> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(ShopMess::getShopName,"%"+name+"%");
        ShopMess shopMess = shopMessDao.selectOne(lambdaQueryWrapper);
        return shopMess;
    }

    @Override
    public void buyShop(String shopid) {
        ShopMess shopMess = shopMessDao.selectById(shopid);
        shopMess.setShopBuy(1);
        BuyMess buyMess=new BuyMess();
        //赞停
        shopMessDao.updateById(shopMess);

    }
}
