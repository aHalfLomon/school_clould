package shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.entity.dto.NewDto;
import shop.entity.po.EvnMess;
import shop.mapper.EvnMessDao;
import shop.service.EvnMessService;

import java.util.List;

/**
 * @Description TODO
 * @ClassName EvnMessServiceImpl
 * @Author 龙涛05664416459
 * @Date 2023/4/29 18:55
 **/
@Service
public class EvnMessServiceImpl implements EvnMessService {

    @Autowired
    EvnMessDao evnMessDao;

    @Override
    public void addNews(NewDto newDto) {
        EvnMess evnMess=new EvnMess();
        evnMess.setEvnImg(newDto.getEvnImg());
        evnMess.setEvnTest(newDto.getEvnTest());
        evnMess.setEvnTitle(newDto.getEvnTitle());
        evnMessDao.insert(evnMess);
    }

    @Override
    public void delete(String newId) {
        evnMessDao.deleteById(newId);
    }

    @Override
    public List<EvnMess> getAllNews() {
        LambdaQueryWrapper<EvnMess> queryWrapper=new LambdaQueryWrapper<>();
//        queryWrapper.like(EvnMess::getEvnTitle,"%"+title+"%");
        List<EvnMess> evnMesses = evnMessDao.selectList(queryWrapper);
        return evnMesses;
    }
}
