package help_sove.service.impl;

import help_sove.mapper.HelpmessMapper;
import help_sove.pojo.HlepMess;
import help_sove.service.HlepMessService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class HlepMessServiceImpl implements HlepMessService {

    @Resource
    private HelpmessMapper helpmessMapper;


    @Override
    public Integer addHelpmess(HlepMess hlepMess) {
        try{
            helpmessMapper.addHelpmess(hlepMess);
            return  1;
        }catch (Exception e){
            return -100;
        }

    }

    @Override
    public Integer delHelpmess(String h_id) {
        try {
            helpmessMapper.delHelpmess(h_id);
            return 1;
        }catch (Exception e){
            return -100;
        }
    }

    @Override
    public Integer uphelpless(HlepMess hlepMess) {
        try{
            helpmessMapper.uphelpless(hlepMess);
            return 1;
        }catch (Exception e){
            return -100;
        }

    }
}
