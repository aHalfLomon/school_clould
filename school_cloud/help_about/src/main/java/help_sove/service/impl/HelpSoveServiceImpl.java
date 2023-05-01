package help_sove.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import help_sove.config.SecurityUtil;
import help_sove.mapper.HelpMessMapper;
import help_sove.mapper.HelpSoveMapper;
import help_sove.pojo.po.HelpMess;
import help_sove.pojo.po.HelpSove;
import help_sove.service.HelpSoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Classname Help_sove_ServerImp
 * @Date 2023/4/13 16:41
 * @Created by wang
 */
@Service
public class HelpSoveServiceImpl implements HelpSoveService {

    @Autowired
    HelpSoveMapper helpSoveMapper;

    @Autowired
    HelpMessMapper helpMessMapper;

    @Override
    public boolean Solve(HelpSove helpSove) {
        helpSove.sethUid(SecurityUtil.getUser().getUserId());
        helpSoveMapper.insert(helpSove);
        LambdaQueryWrapper<HelpMess> queryWrapper=new LambdaQueryWrapper<>();

            HelpMess helpMess = helpMessMapper.selectById(helpSove.getHId());
            helpMess.setHState("1");
        helpMessMapper.updateById(helpMess);
        return true;
    }

    @Override
    public List<HelpSove> getMySolve() {
        String uid= SecurityUtil.getUser().getUserId();
        LambdaQueryWrapper<HelpSove> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(HelpSove::gethUid,uid);
        List<HelpSove> helpSoves = helpSoveMapper.selectList(queryWrapper);
        return helpSoves;
    }

    @Override
    public List<HelpSove> getAllSolve() {
        LambdaQueryWrapper<HelpSove> queryWrapper=new LambdaQueryWrapper<>();
        List<HelpSove> helpSoves = helpSoveMapper.selectList(queryWrapper);
        return helpSoves;
    }
}
