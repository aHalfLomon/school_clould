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

    @GetMapping("/getAll")
    public ResultData getNews(){
        List<EvnMess> allNews = evnMessService.getAllNews();
        return new ResultData("200","ok",allNews);
    }

}
