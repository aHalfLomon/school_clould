package help_sove.service;

import help_sove.pojo.HelpImg;
import org.springframework.stereotype.Service;

/**
 * @Classname Help_ImgServer
 * @Date 2023/4/13 17:01
 * @Created by wang
 */

@Service
public interface Help_ImgServer {
    Integer addImg(HelpImg Img);

    Integer delImg(String h_img_sid,String h_img);
}
