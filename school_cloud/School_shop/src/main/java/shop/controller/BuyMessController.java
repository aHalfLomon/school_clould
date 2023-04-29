package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.entity.po.BuyMess;
import shop.entity.utilsDto.ResultData;
import shop.service.BuyMessService;

import java.util.List;

/**
 * @Description TODO
 * @ClassName BuyMessController
 * @Author 龙涛05664416459
 * @Date 2023/4/17 16:32
 **/
@RestController
@RequestMapping("/shop/buy")
public class BuyMessController {

    @Autowired
    BuyMessService buyMessService;

    //查看我购买的商品
    @GetMapping("/getmubuy")
    public ResultData getBuyShop(){
        List<BuyMess> buyShop = buyMessService.getBuyShop();
        return new ResultData("200","ok",buyShop);
    }

    @GetMapping("/getmucar")
    public ResultData getcar(){
        List<BuyMess> carShop = buyMessService.getcar();
        return new ResultData("200","ok",carShop);
    }

    //在购物车中购买
    @GetMapping("/inshopCat/{id}")
    public ResultData inshopCat(@PathVariable("id") String id){
        buyMessService.buyShopinCar(id);
        return new ResultData("200","ok",null);
    }


}
