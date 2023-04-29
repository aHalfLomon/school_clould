package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.entity.dto.GetShop;
import shop.entity.dto.ShopDto;
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
    public ResultData upMySshop(@RequestBody ShopDto shopMess){
        shopMessService.upMyShop(shopMess);
        return new ResultData("200","ok","null");
    }

    //删除商品
    @DeleteMapping("/delete/{id}")
    public ResultData deleteMySHop(@PathVariable("id") String id){
        shopMessService.deleteMyShop(id);
        return new ResultData("200","ok","null");
    }

    //查询我发布的商品
    @GetMapping("/getMyShop")
    public ResultData getMySHop(){
        List<GetShop>  myUpShop = shopMessService.getMyUpShop();
        return new ResultData("200","ok",myUpShop);
    }

    //查询所有商品，分页
    @GetMapping("/open/get/{p}")
    public ResultData getAll(@PathVariable("p") int p){
        List<GetShop> list=shopMessService.getAllShop(p);
        return new ResultData("200","ok",list);
    }

    //通过id查商品信息
    @GetMapping("/open/getone/{p}")
    public ResultData getOne(@PathVariable("p") String p){
        ShopMess shopMess=shopMessService.getOneShop(p);
        return new ResultData("200","ok",shopMess);
    }

    //通过name查商品信息
    @GetMapping("/open/getbyname/{name}")
    public ResultData getOnebyname(@PathVariable("name") String name){
        List<GetShop>  oneShopbyName = shopMessService.getOneShopbyName(name);
        return new ResultData("200","ok",oneShopbyName);
    }

    //购买商品
    @GetMapping("/buy/{shopid}")
    public ResultData buyShop(@PathVariable("shopid") String shopid){
        shopMessService.buyShop(shopid);
        return new ResultData("200","ok",null);
    }
    //加入购物车
    @GetMapping("/incar/{shopid}")
    public ResultData inCar(@PathVariable("shopid") String shopid){
        shopMessService.incar(shopid);
        return new ResultData("200","ok",null);
    }

    //查询分类商品
    @GetMapping("/open/class/{className}/{p}")
    public ResultData classShop(@PathVariable("className") String className,@PathVariable("p") int p){
        List<GetShop> getShops = shopMessService.classShop(className, p);
        return new ResultData("200","ok",getShops);
    }
}
