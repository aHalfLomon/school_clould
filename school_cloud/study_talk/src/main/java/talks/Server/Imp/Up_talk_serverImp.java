package talks.Server.Imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talks.Pojo.School_talk;
import talks.Server.Up_talk_Server;
import talks.mapper.Up_talk;

import javax.annotation.Resource;

/**
 * @Classname Up_talk_serverImp
 * @Description TODO
 * @Date 2023/4/6 16:31
 * @Created by wang
 */
@Service
@Transactional
public class Up_talk_serverImp implements Up_talk_Server{

    @Resource
    private Up_talk upTalk;
    @Override
    public int uptalk(School_talk schoolTalk){
        try{
            upTalk.uptalk(schoolTalk);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
}
