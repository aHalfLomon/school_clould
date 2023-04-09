package talks.Server.Imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talks.Server.Study_talk_about_server;
import talks.mapper.Study_talk_about;

import javax.annotation.Resource;

/**
 * @Classname Del_talk_serverImp
 * @Description TODO
 * @Date 2023/4/6 16:09
 * @Created by wang
 */
@Service
@Transactional
public class Del_talk_serverImp implements Study_talk_about_server {

    @Resource
    private Study_talk_about delTalk;
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
