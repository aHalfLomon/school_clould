package help_sove.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname Help_ImgServer
 * @Date 2023/4/13 17:01
 * @Created by wang
 */


public interface HelpImgService {

    //添加反馈图片
    void addImg(String url,String hid);

    //根据反馈hid查图片
    List<String> getImg(String hid);

    //根据hid删除图片
    void deImg(String hid);
}
