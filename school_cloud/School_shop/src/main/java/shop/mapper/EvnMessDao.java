package shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import shop.entity.po.EvnMess;

/**
 * (EvnMess)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-29 18:51:12
 */
@Mapper
public interface EvnMessDao extends BaseMapper<EvnMess> {

}

