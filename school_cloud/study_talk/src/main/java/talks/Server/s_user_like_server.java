package talks.Server;

import org.springframework.stereotype.Service;
import talks.Pojo.s_usc;
import talks.Pojo.s_user_like;

import java.util.List;

@Service
public interface s_user_like_server {

    //用户点赞帖子  ---还需要帖子的点赞数减一！！！！
    Integer user_like(s_user_like like);
    //用户点赞该帖子 ----还需要帖子的点赞数减一！！！！
    Integer user_dis_like(String usc_sid,String usc_uid);
    //返回用户点赞的帖子
    List<s_usc> mylike(String usc_uid);

}
