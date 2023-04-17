package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.entity.po.ShopMess;
import shop.entity.utilsDto.ResultData;
import shop.service.ShopMessService;

import java.util.List;

/**
 * @Description TODO
 * @ClassName ShopMessController
 * @Author 龙涛05664416459
 * @Date 2023/4/16 17:10
 **/
@RestController
@RequestMapping("/shop/mess")
public class ShopMessController {

    @Autowired
    ShopMessService shopMessService;

//    发布商品
    @PostMapping("/up")
    public ResultData upMySshop(@RequestBody ShopMess shopMess){
        shopMessService.upMyShop(shopMess);
        return new ResultData("200","ok","null");
    }

    //删除商品

    //查询我发布的商品

    //查询所有商品，分页
}
