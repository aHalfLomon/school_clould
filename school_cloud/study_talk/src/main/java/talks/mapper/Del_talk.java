package talks.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Classname Del_talk
 * @Description TODO
 * @Date 2023/4/6 16:06
 * @Created by wang
 */
@Mapper
@Repository
public interface Del_talk {
    int deltalk(String t_id);
}
