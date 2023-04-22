package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
