package shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import shop.entity.po.ShopMess;

/**
 * (ShopMess)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-16 16:40:23
 */
@Mapper
public interface ShopMessDao extends BaseMapper<ShopMess> {

}

