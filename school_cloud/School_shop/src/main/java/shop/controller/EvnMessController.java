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


    //新增新闻
    @PostMapping("/add")
    public ResultData addNews(@RequestBody NewDto newDto){
        evnMessService.addNews(newDto);
        return new ResultData("200","ok",null);
    }

    //删除新闻
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

    //实时新闻5个，evn_class=1
    @GetMapping("/getRealNews")
    public ResultData getRealNews(){
        List<EvnMess> realNews = evnMessService.getRealNews();
        return new ResultData("200","ok",realNews);
    }

    //热点新闻5个，evn_class=2
    @GetMapping("/getHotNews")
    public ResultData getHotNews(){
        List<EvnMess> hotNews = evnMessService.getHotNews();
        return new ResultData("200","ok",hotNews);
    }

    //所有新闻10个，evn_class=3
    @GetMapping("/getAllNews")
    public ResultData getAllNews(){
        List<EvnMess> allNews = evnMessService.getAllNews();
        return new ResultData("200","ok",allNews);
    }

    //热点讨论5个，evn_class=4
    @GetMapping("/getDiscuss")
    public ResultData getDiscuss(){
        List<EvnMess> discuss = evnMessService.getDiscuss();
        return new ResultData("200","ok",discuss);
    }
}
