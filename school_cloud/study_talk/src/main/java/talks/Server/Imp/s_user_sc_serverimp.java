package talks.Server.Imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talks.Pojo.s_usc;
import talks.Server.s_user_sc_server;
import talks.config.SecurityUtil;
import talks.mapper.s_user_sc;
import talks.mapper.susersc;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class s_user_sc_serverimp implements s_user_sc_server {

    @Resource
    private s_user_sc sc;

    @Autowired
    susersc susersc;

    //增加收藏
    @Override
    public Integer user_sc(s_usc s_usc) {
        return sc.user_sc(s_usc);
    }

    //删除收藏
    @Override
    public Integer user_dis_sc(String usc_sid) {
        String userId = SecurityUtil.getUser().getUserId();
        LambdaQueryWrapper<s_usc> queryWrapper=new LambdaQueryWrapper<s_usc>()
                .eq(s_usc::getUsc_sid,usc_sid)
                .eq(s_usc::getUsc_uid,userId);
        susersc.delete(queryWrapper);
        return 0;
    }

    //我的收藏
    @Override
    public List<s_usc> mysc(String usc_uid) {
        return sc.mysc(usc_uid);
    }


}
