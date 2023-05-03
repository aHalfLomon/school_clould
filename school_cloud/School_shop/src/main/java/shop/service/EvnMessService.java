package shop.service;

import shop.entity.dto.NewDto;
import shop.entity.po.EvnMess;

import java.util.List;

public interface EvnMessService {

    //新增新闻
    void addNews(NewDto newDto);

    //删除新闻
    void delete(String newId);

    //查询新闻
    List<EvnMess> getAllNews(int p);

    List<EvnMess> getBclass(String bclass);
}
