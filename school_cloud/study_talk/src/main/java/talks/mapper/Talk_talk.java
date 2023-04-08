package talks.mapper;


import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import talks.Pojo.Talk_talks;

@Mapper
@Repository
public interface Talk_talk {

    Integer addtalk_talk(Talk_talks talkTalks);

    Integer del_talk_talk(String tk_id);
}
