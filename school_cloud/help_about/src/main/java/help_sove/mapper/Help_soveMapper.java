package help_sove.mapper;

import help_sove.pojo.HelpSove;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Classname Help_soveMapper
 * @Date 2023/4/13 16:27
 * @Created by wang
 */
@Mapper
@Repository
public interface Help_soveMapper {
    Integer soveit(HelpSove helpSove);

    @Delete("DELETE FROM help_sove where h_id = #{h_id}")
    Integer nosoveit(String h_id);

}
