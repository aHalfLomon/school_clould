package talks.Server.Imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talks.Pojo.S_user_like;
import talks.Server.s_user_like_server;
import talks.config.SecurityUtil;
import talks.mapper.*;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class s_user_like_serverimp implements s_user_like_server {

    @Resource
    private s_user_like likes;
    @Resource
    private Study_talk_about studyTalkAbout;
    @Resource
    private S_uesr_likes s_uesr_likes;


    //增加点赞
    @Override
    public Integer user_like(S_user_like like) {
        //添加记录
        likes.user_like(like);
        //同步主表
        studyTalkAbout.addlike(like.getT_like_tid());
        return 200;

    }

    //获取用户的点赞列表
    @Override
    public List<S_user_like> mylike(String t_like_tid) {
        String userId = SecurityUtil.getUser().getUserId();
        return likes.mylike(userId);
    }

    //用户取消点赞
    @Override
    public Integer userdislinke(String t_like_tid) {
        //先删除记录
        String userId = SecurityUtil.getUser().getUserId();
        LambdaQueryWrapper<S_user_like> queryWrapper=new LambdaQueryWrapper<S_user_like>()
                .eq(S_user_like::getT_like_tid,t_like_tid)
                .eq(S_user_like::getT_like_uid,userId);
        s_uesr_likes.delete(queryWrapper);
        //2.同步主表
        studyTalkAbout.disaddlike(t_like_tid);
        return 200;

    }






}
