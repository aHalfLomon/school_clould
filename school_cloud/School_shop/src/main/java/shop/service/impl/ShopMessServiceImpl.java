package shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.config.SecurityUtil;
import shop.entity.po.ShopMess;
import shop.mapper.ShopMessDao;
import shop.service.ShopMessService;

import java.util.List;

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

    @Override
    public List<ShopMess> getAllShop() {
        //分页
        LambdaQueryWrapper<ShopMess> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        List<ShopMess> list=shopMessDao.selectList(lambdaQueryWrapper);
        return list;
    }

    @Override
    public void upMyShop(ShopMess shopMess) {
        //将shopUid赋值
        SecurityUtil.XcUser user=SecurityUtil.getUser();
        shopMess.setShopId(user.getUserId());
        shopMessDao.insert(shopMess);
    }

    @Override
    public void deleteMyShop(String shopId) {

    }

    @Override
    public List<ShopMess> getMyUpShop() {
        return null;
    }
}
