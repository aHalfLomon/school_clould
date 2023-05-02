package talks.Server.Imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talks.Pojo.School_talk;
import talks.Pojo.Talk_Talk_likes;
import talks.Server.Study_talk_about_server;
import talks.config.SecurityUtil;
import talks.mapper.Study_talk_about;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname Del_talk_serverImp
 * @Date 2023/4/6 16:09
 * @Created by wang
 */
@Service
@Transactional
public class Study_talk_about_serverImp implements Study_talk_about_server {

    @Resource
    private Study_talk_about studyTalkAbout;
    @Override
    public Integer deltalk(String t_id) {
        try {
            studyTalkAbout.deltalk(t_id);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
    //返回所有的帖子
    @Override
    public List<School_talk> search_all() {
        try {
            return studyTalkAbout.search_all();
        }
        catch (Exception e){
            return null;
        }
    }

    //user
    @Override
    public Integer addtalk(School_talk schoolTalk) {
        try {
            schoolTalk.setT_uid(SecurityUtil.getUser().getUserId());
            studyTalkAbout.addtalk(schoolTalk);
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

    @Override
    public List<School_talk> search_talk_source(String source) {
//        try {
//            return search_talk.search_talk_source(source);
//        }catch (Exception e){
//            return null;
//        }
        List<School_talk> list = studyTalkAbout.search_talk_source(source);
        return list;
    }


    //返回用户发的帖子
    @Override
    public List<School_talk> mytalk(String uid) {
        try{
            //拿取token
            String userId = SecurityUtil.getUser().getUserId();
            return studyTalkAbout.mytalk(userId);
        }catch (Exception e)
        {
            return null;
        }

    }


    @Override
    public School_talk talk_like_cont(String t_id) {
//        try {
//            int f = studyTalkAbout.talk_like_cont(t_id);
//            return  f;
//        }catch (Exception e) {
//            return -1;
//        }
        return studyTalkAbout.talk_like_cont(t_id);
    }

    @Override
    public School_talk talk_usersc_cont(String t_id) {
//        try {
//            int f = studyTalkAbout.talk_usersc_cont(t_id);
//            return f;
//        }catch (Exception e){
//            return -1;
//        }
        return studyTalkAbout.talk_usersc_cont(t_id);
    }

    @Override
    public Integer uptalk(School_talk schoolTalk){
        try{
            studyTalkAbout.uptalk(schoolTalk);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

//---------------------一下用于对帖子主表的点赞数个收藏数进行增加--------------------------------------
    @Override
    public Integer addcount(String t_id) {
        return studyTalkAbout.addcount(t_id);
    }

    @Override
    public Integer disaddcount(String t_id) {
        return studyTalkAbout.disaddcount(t_id);
    }

    @Override
    public Integer addlike(String t_id) {
        return studyTalkAbout.addlike(t_id);
    }

    @Override
    public Integer disaddlike(String t_id) {
        return studyTalkAbout.disaddlike(t_id);
    }

    //------------------------------------------------------------------------------------------
}
