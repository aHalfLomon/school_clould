package talks.Server.Imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talks.Server.Del_talk_server;
import talks.mapper.Del_talk;

import javax.annotation.Resource;

/**
 * @Classname Del_talk_serverImp
 * @Description TODO
 * @Date 2023/4/6 16:09
 * @Created by wang
 */
@Service
@Transactional
public class Del_talk_serverImp implements Del_talk_server {

    @Resource
    private Del_talk delTalk;
    @Override
    public int deltalk(String t_id) {
        try {
            delTalk.deltalk(t_id);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }
}
