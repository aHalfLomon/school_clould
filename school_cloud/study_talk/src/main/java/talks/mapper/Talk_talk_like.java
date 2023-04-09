package talks.mapper;


import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import talks.Pojo.Talk_Talk_likes;

@Mapper
@Repository
public interface Talk_talk_like {
    Integer addTalkTalk_like(Talk_Talk_likes talkLikes);

    Integer dislike_talk_talk(String like_sid);

}
