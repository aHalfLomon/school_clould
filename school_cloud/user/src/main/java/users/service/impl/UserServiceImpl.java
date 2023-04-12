package users.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.mapper.SuserMapper;
import users.model.po.SUser;
import users.service.UserService;

import java.util.List;

/**
 * @Description TODO
 * @ClassName UserServiceImpl
 * @Author 龙涛05664416459
 * @Date 2023/4/12 19:14
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SuserMapper suserMapper;

    @Override
    public List<SUser> getAllUsers() {
        QueryWrapper<SUser> queryWrapper=new QueryWrapper<SUser>();
        List<SUser> list=suserMapper.selectList(queryWrapper);
        return list;
    }
}
