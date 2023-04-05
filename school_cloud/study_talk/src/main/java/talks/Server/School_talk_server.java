package talks.Server;

import org.springframework.stereotype.Service;
import talks.Pojo.School_talk;

/**
 * @Classname School_talk_server
 * @Description TODO
 * @Date 2023/4/5 20:32
 * @Created by wang
 */
@Service
public interface School_talk_server {
    //发表论坛相关
    School_talk addtalk(School_talk schoolTalk);
}
