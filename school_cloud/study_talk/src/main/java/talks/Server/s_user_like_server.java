package talks.Server;

import org.springframework.stereotype.Service;
import talks.Pojo.s_usc;
import talks.Pojo.S_user_like;

import java.util.List;

@Service
public interface s_user_like_server {

    //用户点赞帖子  ---还需要帖子的点赞数减一！！！！
    Integer user_like(S_user_like like);
    //用户点赞该帖子 ----还需要帖子的点赞数减一！！！！
    //返回用户点赞的帖子
    List<S_user_like> mylike(String t_like_uid);

    Integer userdislinke(String t_like_tid);
    
    S_user_like islike(String t_like_tid);

}
