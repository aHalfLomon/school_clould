package talks.Server.Imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talks.Pojo.S_user_like;
import talks.Pojo.School_talk;
import talks.Pojo.s_usc;
import talks.Server.s_user_sc_server;
import talks.config.SecurityUtil;
import talks.mapper.S_talk;
import talks.mapper.Study_talk_about;
import talks.mapper.s_user_sc;
import talks.mapper.susersc;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class s_user_sc_serverimp implements s_user_sc_server {

    @Resource
    private s_user_sc sc;
    @Resource
    private Study_talk_about studyTalkAbout;

    @Resource
    S_talk s_talk;

    @Autowired
    susersc susersc;

    //增加收藏
    @Override
    public Integer user_sc(s_usc s_usc) {
        try {
            //在收藏表中添加记录
            String userId = SecurityUtil.getUser().getUserId();
            s_usc.setUsc_uid(userId);
            sc.user_sc(s_usc);
            //在主表中对收藏数加一
            studyTalkAbout.addcount(s_usc.getUsc_sid());
            //System.out.println(s_usc.getUsc_uid());
            return 200;
        }catch (Exception e){
            return -1;
        }
    }

    //删除收藏
    @Override
    public Integer user_dis_sc(String usc_sid) {
        try {
            //在收藏表中删除表
            String userId = SecurityUtil.getUser().getUserId();
            LambdaQueryWrapper<s_usc> queryWrapper=new LambdaQueryWrapper<s_usc>()
                    .eq(s_usc::getUsc_sid,usc_sid)
                    .eq(s_usc::getUsc_uid,userId);
            susersc.delete(queryWrapper);
            //在主表中对收藏数减一
            studyTalkAbout.disaddcount(usc_sid);
            return 200;
        }catch (Exception e){
            return -1;
        }

    }

    //我的收藏
    @Override
    public List<s_usc> mysc(String usc_uid) {
        String userId = SecurityUtil.getUser().getUserId();
        return sc.mysc(userId);
    }

    @Override
    public s_usc issc(String usc_sid) {
        String userId = SecurityUtil.getUser().getUserId();
        LambdaQueryWrapper<s_usc> queryWrapper=new LambdaQueryWrapper<s_usc>()
                .eq(s_usc::getUsc_sid,usc_sid)
                .eq(s_usc::getUsc_uid,userId);
        return susersc.selectOne(queryWrapper);
    }

    //根据tid查帖子主人id
    @Override
    public String getTuid(String tid) {
        LambdaQueryWrapper<School_talk> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(School_talk::getT_id,tid);

        School_talk school_talk = s_talk.selectOne(queryWrapper);

        return school_talk.getT_uid();
    }


}
