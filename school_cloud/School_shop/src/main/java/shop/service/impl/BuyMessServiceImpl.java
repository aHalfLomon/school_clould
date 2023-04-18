package shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.entity.po.BuyMess;
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
        LambdaQueryWrapper<BuyMess> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(BuyMess::getBuyId,"100");
        List<BuyMess> buyMesses = buyMessDao.selectList(lambdaQueryWrapper);
        return buyMesses;
    }
}
