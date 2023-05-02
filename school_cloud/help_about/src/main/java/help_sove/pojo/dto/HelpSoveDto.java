package help_sove.pojo.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @ClassName HelpSoveDto
 * @Author 龙涛05664416459
 * @Date 2023/5/2 20:36
 **/
@Data
public class HelpSoveDto {

    private String hid;
    //解决人
    private String hsoveperson;
    //解决状态;0解决不了 1解决
    private String hstate;
    //解决方案
    private String hsfa;

}
