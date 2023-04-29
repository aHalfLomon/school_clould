package talks.Server.Imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talks.Pojo.Talk_Talk_likes;
import talks.Server.Talk_talk_likeserver;
import talks.config.SecurityUtil;
import talks.mapper.Talk_talk_like;

import javax.annotation.Resource;
@Service
@Transactional
public class Talk_talklikeserverImp implements Talk_talk_likeserver {

    @Resource
    private Talk_talk_like talkLike;
    //user
    @Override
    public Integer addTalkTalk_like(Talk_Talk_likes talkLikes) {
        try{
            talkLikes.setLike_uid(SecurityUtil.getUser().getUserId());
            int f = talkLike.addTalkTalk_like(talkLikes);
            return f;
        }catch (Exception e){
            return -1000;
        }
    }

    @Override
    public Integer dislike_talk_talk(String like_sid) {
        try{
            return talkLike.dislike_talk_talk(like_sid);
        }catch (Exception e){
            return -1000;
        }
    }
}
