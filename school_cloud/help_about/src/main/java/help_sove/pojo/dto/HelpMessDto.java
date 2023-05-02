package help_sove.pojo.dto;

import help_sove.pojo.po.HelpMess;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description TODO
 * @ClassName HelpMessDto
 * @Author 龙涛05664416459
 * @Date 2023/4/30 23:52
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelpMessDto extends HelpMess {
    //反馈图片
    private List<String> urlLists;

    //用户姓名
    private String userName;

    //用户头像
    private String userHead;
}
