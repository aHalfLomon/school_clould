package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RequestMapping("/shop")
public class ShopMessController {

    @Autowired
    ShopMessService service;

    //发布商品
//    @PostMapping("/up")
//    public ResultData upMySshop(){
//
//    }

    //删除商品

    //查询我发布的商品

    //查询所有商品，分页
}
