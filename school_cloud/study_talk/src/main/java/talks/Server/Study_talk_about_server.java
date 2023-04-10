package talks.Server;

import org.springframework.stereotype.Service;
import talks.Pojo.School_talk;

import java.util.List;

/**
 * @Classname Del_talk_server
 * @Description TODO
 * @Date 2023/4/6 16:07
 * @Created by wang
 */
@Service
public interface Study_talk_about_server {
    Integer addtalk(School_talk schoolTalk);
    //删除帖子
    Integer deltalk(String t_id);
    //更新帖子
    Integer uptalk(School_talk schoolTalk);

    //搜索相关
    School_talk talk_like_cont(String t_id);

    School_talk talk_usersc_cont(String t_id);
    List<School_talk> search_talk_source(String source);


}
