package help_sove.service.impl;

import help_sove.mapper.Help_ImageMapper;
import help_sove.mapper.Help_soveMapper;
import help_sove.pojo.HelpSove;
import help_sove.service.Help_sove_Server;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname Help_sove_ServerImp
 * @Date 2023/4/13 16:41
 * @Created by wang
 */

@Service
public class Help_sove_ServerImp implements Help_sove_Server {

    @Resource
    private Help_soveMapper helpSoveMapper;
    @Override
    public Integer soveit(HelpSove helpSove) {
        return helpSoveMapper.soveit(helpSove);
    }

    @Override
    public Integer nosoveit(String h_id) {
        return helpSoveMapper.nosoveit(h_id);
    }
}
