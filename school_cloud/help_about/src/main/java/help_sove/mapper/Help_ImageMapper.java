package help_sove.mapper;

import help_sove.pojo.HelpImg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Classname Help_ImageMappe
 * @Date 2023/4/13 16:59
 * @Created by wang
 */
@Mapper
@Repository
public interface Help_ImageMapper {
    Integer addImg(HelpImg Img);

    @Delete("DELETE FROM help_img where h_img_sid = #{h_img_sid} and h_img = ${h_img}")
    Integer delImg(String h_img_sid,String h_img);

    

}
