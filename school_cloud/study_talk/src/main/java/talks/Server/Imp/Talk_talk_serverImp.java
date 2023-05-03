package talks.Server.Imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talks.Pojo.S_user_like;
import talks.Pojo.Talk_talks;
import talks.Server.Talk_talk_server;
import talks.config.SecurityUtil;
import talks.mapper.Talk_talk;
import talks.mapper.Talk_talksplus;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class Talk_talk_serverImp implements Talk_talk_server {

    @Resource
    private Talk_talk talkTalk;
    @Resource
    private Talk_talksplus talksplus;

    //user
    @Override
    public Integer addtalk_talk(Talk_talks talkTalks) {
        try{
            talkTalks.setTk_uid(SecurityUtil.getUser().getUserId());
            int f = talkTalk.addtalk_talk(talkTalks);
            return f;
        }catch (Exception e){
            return -1;
        }
        //  return  talkTalk.addtalk_talk(talkTalks);
    }

    //-------------------------------------------------------------------
    @Override
    public Integer del_talk_talk(String tk_id) {
//        try{
//
//
//        }catch (Exception e){
//            return -1;
//        }
//      //  return null;
//    }

    LambdaQueryWrapper<Talk_talks> queryWrapper=new LambdaQueryWrapper<Talk_talks>()
            .eq(Talk_talks::getTk_id,tk_id);
    Talk_talks talks = talksplus.selectOne(queryWrapper);
    if(SecurityUtil.getUser().getUserId().equals(talks.getTk_uid()))
    {
        //删除评论
        //talkTalk.del_talk_talk(tk_id);
        LambdaQueryWrapper<Talk_talks> queryWrapper2=new LambdaQueryWrapper<Talk_talks>()
                .eq(Talk_talks::getTk_id,tk_id)
                .eq(Talk_talks::getTk_uid,SecurityUtil.getUser().getUserId());
        talksplus.delete(queryWrapper2);
        return 200;
    }else return -100;}

    @Override
    public List<Talk_talks> Talks_talks(String tk_tid) {
        LambdaQueryWrapper<Talk_talks> queryWrapper3=new LambdaQueryWrapper<Talk_talks>()
                .eq(Talk_talks::getTk_tid,tk_tid);
        List<Talk_talks> talks =talksplus.selectList(queryWrapper3);
        return talks;
    }

}
