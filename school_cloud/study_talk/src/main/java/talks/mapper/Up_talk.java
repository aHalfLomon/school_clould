package talks.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import talks.Pojo.School_talk;

/**
 * @Classname Up_talk
 * @Description TODO
 * @Date 2023/4/6 16:28
 * @Created by wang
 */
@Mapper
@Repository
public interface Up_talk {
    int uptalk(School_talk schoolTalk);
}
