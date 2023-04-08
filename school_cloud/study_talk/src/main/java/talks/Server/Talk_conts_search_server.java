package talks.Server;

import org.springframework.stereotype.Service;

/**
 * @Classname Talk_conts_search_server
 * @Description TODO
 * @Date 2023/4/8 10:07
 * @Created by wang
 */
@Service
public interface Talk_conts_search_server{
    Integer talk_like_cont(String t_id);

    Integer talk_usersc_cont(String t_id);

}
