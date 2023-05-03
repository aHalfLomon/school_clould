package shop.service;

import org.springframework.web.bind.annotation.GetMapping;
import shop.entity.dto.NewDto;
import shop.entity.po.EvnMess;
import shop.entity.utilsDto.ResultData;

import java.util.List;

public interface EvnMessService {

    //新增新闻
    void addNews(NewDto newDto);

    //删除新闻
    void delete(String newId);

    //查询新闻
    List<EvnMess> getAllNews(int p);

    List<EvnMess> getBclass(String bclass);


    //实时新闻5个，evn_class=1
     List<EvnMess> getRealNews();

    //热点新闻5个，evn_class=2
     List<EvnMess> getHotNews();

    //所有新闻10个，evn_class=3
     List<EvnMess> getAllNews();

    //热点讨论5个，evn_class=4
     List<EvnMess> getDiscuss();
}
