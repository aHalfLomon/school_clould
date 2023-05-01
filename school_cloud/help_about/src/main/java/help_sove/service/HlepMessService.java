package help_sove.service;

import help_sove.pojo.dto.HelpMessDto;
import help_sove.pojo.vo.HelpMessVo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * (HlepMess)表服务接口
 *
 * @author makejava
 * @since 2023-04-11 11:37:12
 */
@Service
public interface HlepMessService {

    //增加一条反馈的帖子
    boolean addHelp(HelpMessVo helpMessVo);

    //删除我反馈的帖子
    boolean delMyHelp(String id);

    //修改反馈
    boolean upMyHelp (HelpMessVo helpMessVo);

    //查询我反馈的帖子
    List<HelpMessDto> getMyHelp();

    //查询所有反馈
    List<HelpMessDto> getAllHelp();
}
