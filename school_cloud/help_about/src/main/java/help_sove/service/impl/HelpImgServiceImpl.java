package help_sove.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import help_sove.mapper.HlepImgMapper;
import help_sove.pojo.po.HlepImg;
import help_sove.service.HelpImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Help_ImgIMp
 * @Date 2023/4/13 17:02
 * @Created by wang
 */

@Service
public class HelpImgServiceImpl implements HelpImgService {

    @Autowired
    HlepImgMapper hlepImgMapper;

    @Override
    public void addImg(String url, String hid) {
        HlepImg hlepImg=new HlepImg();
        hlepImg.setHImgUrl(url);
        hlepImg.setHImgSid(hid);
        hlepImgMapper.insert(hlepImg);
    }

    @Override
    public List<String> getImg(String hid) {
        LambdaQueryWrapper<HlepImg> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(HlepImg::getHImgSid,hid);
        List<HlepImg> hlepImgs = hlepImgMapper.selectList(queryWrapper);
        List<String> list=new ArrayList<>();
        for (HlepImg hlepImg:hlepImgs){
            list.add(hlepImg.getHImgUrl());
        }
        return list;
    }

    @Override
    public void deImg(String hid) {
        LambdaQueryWrapper<HlepImg> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(HlepImg::getHImgSid,hid);
        hlepImgMapper.delete(queryWrapper);
    }
}
