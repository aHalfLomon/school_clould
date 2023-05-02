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

    List<School_talk> search_all();
    Integer addtalk(School_talk schoolTalk);
    //删除帖子
    Integer deltalk(String t_id);
    //更新帖子
    Integer uptalk(School_talk schoolTalk);

    //搜索相关
    School_talk talk_like_cont(String t_id);

    School_talk talk_usersc_cont(String t_id);
    List<School_talk> search_talk_source(String source);
    List<School_talk> mytalk(String uid);

    //用于对主表中的点赞和收藏数进行操作
    Integer addcount(String t_id);
    Integer disaddcount(String t_id);
    Integer addlike(String t_id);
    Integer disaddlike(String t_id);



}
