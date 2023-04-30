package talks.Server.Imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talks.Pojo.s_usc;
import talks.Server.s_user_sc_server;
import talks.config.SecurityUtil;
import talks.mapper.Study_talk_about;
import talks.mapper.s_user_like;
import talks.mapper.s_user_sc;
import talks.mapper.susersc;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class s_user_like_serverimp implements s_user_like{

    @Resource
    private s_user_like like;
    @Resource
    private Study_talk_about studyTalkAbout;

    @Autowired
    susersc susersc;

    @Override
    public Integer user_like(s_usc s_usc) {
        return null;
    }

    @Override
    public Integer user_dis_like(String usc_sid, String usc_uid) {
        return null;
    }

    @Override
    public List<s_usc> mylike(String usc_uid) {
        return null;
    }

    //增加收藏



}
