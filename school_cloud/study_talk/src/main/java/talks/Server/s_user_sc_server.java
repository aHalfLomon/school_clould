package talks.Server;

import org.springframework.stereotype.Service;
import talks.Pojo.s_usc;

import java.util.List;

@Service
public interface s_user_sc_server {

    Integer user_sc(s_usc s_usc);
    //用户取消收藏该帖子 ----还需要帖子的收藏数减一！！！！
    Integer user_dis_sc(String usc_sid,String usc_uid);
    //返回用户收藏的帖子
    List<s_usc> mysc(String usc_uid);

}
