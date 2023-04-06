package talks.Server.Imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talks.Pojo.School_talk;
import talks.Server.School_talk_server;
import talks.mapper.Sent_talk;

import javax.annotation.Resource;

/**
 * @Classname School_talk_server_Imp
 * @Description TODO
 * @Date 2023/4/5 20:37
 * @Created by wang
 */
@Service
@Transactional
public class School_talk_server_Imp implements School_talk_server {
    @Resource
    private Sent_talk sentTalk;

    @Override
    public int addtalk(School_talk schoolTalk) {
        return sentTalk.addtalk(schoolTalk);
    }
}
