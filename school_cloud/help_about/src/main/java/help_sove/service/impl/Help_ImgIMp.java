package help_sove.service.impl;

import help_sove.mapper.Help_ImageMapper;
import help_sove.pojo.HelpImg;
import help_sove.service.Help_ImgServer;

import javax.annotation.Resource;

/**
 * @Classname Help_ImgIMp
 * @Description TODO
 * @Date 2023/4/13 17:02
 * @Created by wang
 */
public class Help_ImgIMp implements Help_ImgServer {

    @Resource
    private Help_ImageMapper helpImageMapper;
    @Override
    public Integer addImg(HelpImg Img) {
        return helpImageMapper.addImg(Img);
    }

    @Override
    public Integer delImg(String h_img_sid,String h_img) {
        return helpImageMapper.delImg(h_img_sid,h_img);
    }
}
