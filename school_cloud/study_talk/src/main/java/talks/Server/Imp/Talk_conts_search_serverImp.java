package talks.Server.Imp;

import org.springframework.stereotype.Service;
import talks.Server.Talk_conts_search_server;

/**
 * @Classname Talk_conts_search_serverImp
 * @Description TODO
 * @Date 2023/4/8 10:14
 * @Created by wang
 */
@Service
public class Talk_conts_search_serverImp implements Talk_conts_search_server{

    private Talk_conts_search talkContsSearch;
    @Override
    public Integer talk_like_cont(String t_id) {
        try {
            int f = talkContsSearch.talk_like_cont(t_id);
            return  f;
        }catch (Exception e) {
            return -1;
        }
        //return talkContsSearch.talk_like_cont(t_id);
    }

    @Override
    public Integer talk_usersc_cont(String t_id) {
        try {
            int f = talkContsSearch.talk_usersc_cont(t_id);
            return f;
        }catch (Exception e){
            return -1;
        }

    }
}
