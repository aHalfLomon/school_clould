package help_sove.service.impl;

import help_sove.mapper.HelpMessDao;
import help_sove.pojo.dto.HelpMessDto;
import help_sove.pojo.vo.HelpMessVo;
import help_sove.service.HlepMessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HlepMessServiceImpl implements HlepMessService {

    @Autowired
    HelpMessDao helpMessDao;

    @Override
    public boolean addHelp(HelpMessVo helpMessVo) {
        return false;
    }

    @Override
    public boolean delMyHelp(String id) {
        return false;
    }

    @Override
    public boolean upMyHelp(HelpMessVo helpMessVo) {
        return false;
    }

    @Override
    public List<HelpMessDto> getMyHelp() {
        return null;
    }

    @Override
    public List<HelpMessDto> getAllHelp() {
        return null;
    }
}
