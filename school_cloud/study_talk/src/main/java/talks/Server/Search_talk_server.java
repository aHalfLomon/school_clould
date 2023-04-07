package talks.Server;

import org.springframework.stereotype.Service;
import talks.Pojo.School_talk;

import java.util.List;

/**
 * @Classname Search_talk_server
 * @Description TODO
 * @Date 2023/4/7 10:35
 * @Created by wang
 */
@Service
public interface Search_talk_server {
    List<School_talk> search_talk_source(String source);
}
