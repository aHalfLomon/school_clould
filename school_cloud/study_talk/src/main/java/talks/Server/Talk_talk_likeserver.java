package talks.Server;

import org.springframework.stereotype.Service;
import talks.Pojo.Talk_Talk_likes;

@Service
public interface Talk_talk_likeserver {
    Integer addTalkTalk_like(Talk_Talk_likes talkLikes);

    Integer dislike_talk_talk(String like_sid);
}
