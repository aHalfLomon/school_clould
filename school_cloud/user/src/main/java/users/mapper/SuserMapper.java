package users.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import users.model.po.SUser;

/**
 * @Description TODO
 * @ClassName SuserMapper
 * @Author 龙涛05664416459
 * @Date 2023/4/12 19:12
 **/
@Mapper
public interface SuserMapper extends BaseMapper<SUser> {
}
