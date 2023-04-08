package talks.Server.Imp;

import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talks.Pojo.Talk_talks;
import talks.Server.Talk_talk_server;
import talks.mapper.Talk_talk;
@Service
@Transactional
public class Talk_talk_serverImp implements Talk_talk_server {
    private Talk_talk talkTalk;
    @Override
    public Integer addtalk_talk(Talk_talks talkTalks) {
        try{
            int f = talkTalk.addtalk_talk(talkTalks);
            return f;
        }catch (Exception e){
            return -1;
        }
    }

    @Override
    public Integer del_talk_talk(String tk_id) {
        try{
            int f = talkTalk.del_talk_talk(tk_id);
            return f;
        }catch (Exception e){
            return -1;
        }
      //  return null;
    }
}
