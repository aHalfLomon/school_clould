package shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.entity.dto.NewDto;
import shop.entity.po.EvnMess;
import shop.entity.po.ShopMess;
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
        evnMess.setEvnClass(newDto.getEvnClass());
        evnMessDao.insert(evnMess);
    }

    @Override
    public void delete(String newId) {
        evnMessDao.deleteById(newId);
    }

    @Override
    public List<EvnMess> getAllNews(int p) {
        LambdaQueryWrapper<EvnMess> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        Page<EvnMess> page= new Page<>(p,6);
        page=evnMessDao.selectPage(page,null);
        List<EvnMess> list=page.getRecords();
        return list;
    }

    @Override
    public List<EvnMess> getBclass(String bclass) {
        LambdaQueryWrapper<EvnMess> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(EvnMess::getEvnClass,bclass);
        List<EvnMess> evnMesses = evnMessDao.selectList(lambdaQueryWrapper);
        return evnMesses;
    }
}
