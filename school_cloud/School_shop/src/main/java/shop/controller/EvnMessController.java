package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.entity.dto.NewDto;
import shop.entity.po.EvnMess;
import shop.entity.utilsDto.ResultData;
import shop.service.EvnMessService;

import java.util.List;

/**
 * @Description TODO
 * @ClassName EvnMessController
 * @Author 龙涛05664416459
 * @Date 2023/4/29 19:09
 **/
@RequestMapping("/shop/news")
@RestController
public class EvnMessController {

    @Autowired
    EvnMessService evnMessService;

    @PostMapping("/add")
    public ResultData addNews(@RequestBody NewDto newDto){
        evnMessService.addNews(newDto);
        return new ResultData("200","ok",null);
    }

    @DeleteMapping("/dele/{id}")
    public ResultData deleNews(@PathVariable("id") String id){
        evnMessService.delete(id);
        return new ResultData("200","ok",null);
    }

    @GetMapping("/getAll/{p}")
    public ResultData getNews(@PathVariable("p") int p){
        List<EvnMess> allNews = evnMessService.getAllNews(p);
        return new ResultData("200","ok",allNews);
    }

    @GetMapping("/getbClass/{bclass}")
    public ResultData getbclass(@PathVariable("bclass") String bclass){
        List<EvnMess> bclass1 = evnMessService.getBclass(bclass);
        return new ResultData("200","ok",bclass1);
    }

}
