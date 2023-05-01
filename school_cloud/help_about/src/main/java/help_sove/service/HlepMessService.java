package help_sove.service;

import help_sove.pojo.dto.HelpMessDto;
import help_sove.pojo.vo.HelpMessVo;
import help_sove.pojo.vo.UpHelpMessVo;

import java.util.List;

/**
 * (HlepMess)表服务接口
 *
 * @author makejava
 * @since 2023-04-11 11:37:12
 */

public interface HlepMessService {

    //增加一条反馈的帖子
    boolean addHelp(HelpMessVo helpMessVo);

    //删除我反馈的帖子
    boolean delMyHelp(String hid);

    //修改反馈
    boolean upMyHelp (UpHelpMessVo upHelpMessVo);

    //查询我反馈的帖子
    List<HelpMessDto> getMyHelp();

    //查询所有反馈
    List<HelpMessDto> getAllHelp();
}
