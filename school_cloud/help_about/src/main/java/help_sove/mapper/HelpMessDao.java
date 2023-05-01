package help_sove.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import help_sove.pojo.po.HelpMess;
import org.apache.ibatis.annotations.Mapper;


/**
 * (HelpMess)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-30 23:36:52
 */
@Mapper
public interface HelpMessDao extends BaseMapper<HelpMess> {

}

