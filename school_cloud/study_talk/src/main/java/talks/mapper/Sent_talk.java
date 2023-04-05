package talks.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import talks.Pojo.School_talk;

/**
 * @Classname Sent_talk
 * @Description TODO
 * @Date 2023/4/5 20:00
 * @Created by wang
 */
@Mapper
@Repository
public interface Sent_talk {
    //发表论坛
    School_talk addtalk(School_talk schoolTalk);

}
