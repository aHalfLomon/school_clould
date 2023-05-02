package talks.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import talks.Pojo.S_user_like;

import java.util.List;

@Mapper
@Repository
public interface s_user_like {
    //帖子点赞相关

    //用户收藏帖子  ---还需要帖子的点赞数减一！！！！
    Integer user_like(S_user_like like);

    List<S_user_like> mylike(String t_like_uid);
    //用户取消点赞该帖子 ----还需要帖子的点赞数减一！！！！
    Integer userdislinke(String t_like_tid);


}
