package help_sove.service;

import help_sove.pojo.dto.HelpSoveDto;
import help_sove.pojo.po.HelpSove;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname Help_sove_Server
 * @Date 2023/4/13 16:40
 * @Created by wang
 */

public interface HelpSoveService {

    //添加解决方案
    boolean Solve(HelpSoveDto helpSoveDto);

    //查询我的解决方案
    List<HelpSove> getMySolve();

    //查询所有的解决方案
    List<HelpSove> getAllSolve();
}
