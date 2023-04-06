package talks.Server;

import org.springframework.stereotype.Service;
import talks.Pojo.School_talk;

/**
 * @Classname Up_talk_Server
 * @Description TODO
 * @Date 2023/4/6 16:29
 * @Created by wang
 */
@Service
public interface Up_talk_Server {
    int uptalk(School_talk schoolTalk);
}
