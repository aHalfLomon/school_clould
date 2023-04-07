package talks.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import talks.Pojo.School_talk;

/**
 * @Classname Serrch_talk
 * @Description TODO
 * @Date 2023/4/7 10:28
 * @Created by wang
 */
@Mapper
@Repository
public interface Search_talk {
    School_talk search_talk_source(String source);
}
