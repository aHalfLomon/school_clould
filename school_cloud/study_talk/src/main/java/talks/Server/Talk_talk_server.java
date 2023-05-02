package talks.Server;

import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import talks.Pojo.Talk_talks;

import java.util.List;

@Service
public interface Talk_talk_server {
    Integer addtalk_talk(Talk_talks talkTalks);

    Integer del_talk_talk(String tk_id);

    List<Talk_talks> Talks_talks(String tk_tid);

}
