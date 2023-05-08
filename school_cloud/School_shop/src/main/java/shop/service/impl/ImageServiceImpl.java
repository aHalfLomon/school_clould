package shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.entity.po.ShopImg;
import shop.mapper.ShopImgDao;
import shop.service.ImageService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @ClassName ImageServiceImpl
 * @Author 龙涛05664416459
 * @Date 2023/4/28 22:45
 **/
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ShopImgDao shopImgDao;

    @Override
    public void addImg(String url, String shopId, int f) {
        try {
            ShopImg shopImg=new ShopImg();
            shopImg.setSImgUrl(url);
            shopImg.setSImgSid(shopId);
            shopImg.setSImg(f);
            shopImgDao.insert(shopImg);
        }catch (Exception e){

        }
    }

    @Override
    public List<String> getList(String shopId) {
        try {
            LambdaQueryWrapper<ShopImg> queryWrapper=new LambdaQueryWrapper<>();
            queryWrapper.eq(ShopImg::getSImgSid,shopId);
            queryWrapper.select(ShopImg::getSImgUrl);
            List<ShopImg> shopImgs = shopImgDao.selectList(queryWrapper);
            List<String> list=new ArrayList<>();
            for (ShopImg shopImg:shopImgs){
                list.add(shopImg.getSImgUrl());
            }
            return list;
        }catch (Exception e){
            return null;
        }
    }
}
