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
        try {
            EvnMess evnMess=new EvnMess();
            evnMess.setEvnImg(newDto.getEvnImg());
            evnMess.setEvnTest(newDto.getEvnTest());
            evnMess.setEvnTitle(newDto.getEvnTitle());
            evnMess.setEvnClass(newDto.getEvnClass());
            evnMessDao.insert(evnMess);
        }catch (Exception e){

        }
    }

    @Override
    public void delete(String newId) {
        try {
            evnMessDao.deleteById(newId);
        }catch (Exception e){

        }
    }

    @Override
    public List<EvnMess> getAllNews(int p) {
        try {
            LambdaQueryWrapper<EvnMess> lambdaQueryWrapper=new LambdaQueryWrapper<>();
            Page<EvnMess> page= new Page<>(p,6);
            page=evnMessDao.selectPage(page,null);
            List<EvnMess> list=page.getRecords();
            return list;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<EvnMess> getBclass(String bclass) {
        try {
            LambdaQueryWrapper<EvnMess> lambdaQueryWrapper=new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(EvnMess::getEvnClass,bclass);
            List<EvnMess> evnMesses = evnMessDao.selectList(lambdaQueryWrapper);
            return evnMesses;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<EvnMess> getRealNews() {
        try {
            LambdaQueryWrapper<EvnMess> queryWrapper=new LambdaQueryWrapper<>();
            queryWrapper.eq(EvnMess::getEvnClass,"1");
            List<EvnMess> evnMesses = evnMessDao.selectList(queryWrapper);
            return evnMesses;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<EvnMess> getHotNews() {
        try {
            LambdaQueryWrapper<EvnMess> queryWrapper=new LambdaQueryWrapper<>();
            queryWrapper.eq(EvnMess::getEvnClass,"2");
            List<EvnMess> evnMesses = evnMessDao.selectList(queryWrapper);
            return evnMesses;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<EvnMess> getAllNews() {
        try {
            LambdaQueryWrapper<EvnMess> queryWrapper=new LambdaQueryWrapper<>();
            queryWrapper.eq(EvnMess::getEvnClass,"3");
            List<EvnMess> evnMesses = evnMessDao.selectList(queryWrapper);
            return evnMesses;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<EvnMess> getDiscuss() {
        try {
            LambdaQueryWrapper<EvnMess> queryWrapper=new LambdaQueryWrapper<>();
            queryWrapper.eq(EvnMess::getEvnClass,"4");
            List<EvnMess> evnMesses = evnMessDao.selectList(queryWrapper);
            return evnMesses;
        }catch (Exception e){
            return null;
        }
    }
}
