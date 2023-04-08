package talks.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @Classname Talk_conts_search
 * @Description TODO
 * @Date 2023/4/8 9:59
 * @Created by wang
 */
@Mapper
@Repository
public interface Talk_conts_search {
    Integer talk_like_cont(String t_id);

    Integer talk_usersc_cont(String t_id);
}
