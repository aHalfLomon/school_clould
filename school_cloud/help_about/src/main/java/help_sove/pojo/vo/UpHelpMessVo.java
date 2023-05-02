package help_sove.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @ClassName HelpMessVo
 * @Author 龙涛05664416459
 * @Date 2023/4/30 23:58
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpHelpMessVo {
    private String Hid;
    //求助，反馈内容
    private String hSource;
    //反馈的地点
    private String hLocation;
    //图片
    private String[] url;
}
