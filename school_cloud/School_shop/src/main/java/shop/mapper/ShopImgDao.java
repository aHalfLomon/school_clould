package shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import shop.entity.po.ShopImg;


/**
 * (ShopImg)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-16 16:41:03
 */
@Mapper
public interface ShopImgDao extends BaseMapper<ShopImg> {

}

