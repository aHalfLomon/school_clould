package shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lt.feign.clients.UserClient;
import com.lt.feign.pojo.UserUn;
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

    @Autowired
    UserClient userClient;

    //查询所有商品，分页
    @Override
    public List<GetShop> getAllShop(int p) {
        //分页
        Page<ShopMess> page= new Page<>(p,6);
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
            UserUn userUn= userClient.findUserUn(shopMess.getShopUid());
            getShop.setUserName(userUn.getUserName());
            getShop.setUserUrl(userUn.getUserAvatar());
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

    //查询我发布的商品
    @Override
    public List<GetShop> getMyUpShop() {
        SecurityUtil.XcUser user=SecurityUtil.getUser();
        LambdaQueryWrapper<ShopMess> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(ShopMess::getShopUid,user.getUserId());
        List<ShopMess> list = shopMessDao.selectList(queryWrapper);
        System.out.println("=======================================================");
        System.out.println(list);
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
            UserUn userUn= userClient.findUserUn(shopMess.getShopUid());
            getShop.setUserName(userUn.getUserName());
            getShop.setUserUrl(userUn.getUserAvatar());
            getShop.setUrlList(imageService.getList(shopMess.getShopId()));
            getShops.add(getShop);
        }
        return getShops;
    }

    @Override
    public ShopMess getOneShop(String shopId) {
        ShopMess shopMess=shopMessDao.selectById(shopId);
        return shopMess;
    }

    //通过name查商品信息
    @Override
    public List<GetShop> getOneShopbyName(String name) {
        LambdaQueryWrapper<ShopMess> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(ShopMess::getShopName,"%"+name+"%");
        List<ShopMess> list = shopMessDao.selectList(lambdaQueryWrapper);
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
            UserUn userUn= userClient.findUserUn(shopMess.getShopUid());
            getShop.setUserName(userUn.getUserName());
            getShop.setUserUrl(userUn.getUserAvatar());
            getShop.setUrlList(imageService.getList(shopMess.getShopId()));
            getShops.add(getShop);
        }
        return getShops;
    }

    //直接购买商品
    @Override
    public void buyShop(String shopid) {
        //修改商品是否为购买
        ShopMess shopMess = shopMessDao.selectById(shopid);
        shopMess.setShopBuy(1);
        shopMessDao.updateById(shopMess);
        //新增购买订单信息
        List<String> list = imageService.getList(shopid);
        if (list==null){
            buyMessService.buyShop(shopMess,"null");
        }else {
            buyMessService.buyShop(shopMess,list.get(0));
        }
    }

    //加入购物车
    @Override
    public void incar(String shopid) {
        ShopMess shopMess = shopMessDao.selectById(shopid);
        List<String> list = imageService.getList(shopid);
        buyMessService.inShopCar(shopMess,list.get(0));
    }

    @Override
    public List<GetShop> classShop(String className,int p) {
        LambdaQueryWrapper<ShopMess> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(ShopMess::getShopClass,className);
        Page<ShopMess> page= new Page<>(p,6);
        page=shopMessDao.selectPage(page,queryWrapper);
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
            UserUn userUn= userClient.findUserUn(shopMess.getShopUid());
            getShop.setUserName(userUn.getUserName());
            getShop.setUserUrl(userUn.getUserAvatar());
            getShop.setUrlList(imageService.getList(shopMess.getShopId()));
            getShops.add(getShop);
        }
        return getShops;
    }
}
