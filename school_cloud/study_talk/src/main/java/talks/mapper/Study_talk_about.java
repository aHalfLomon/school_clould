package talks.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import talks.Pojo.School_talk;

import java.util.List;

/**
 * @Classname Del_talk
 * @Date 2023/4/6 16:06
 * @Created by wang
 */
@Mapper
@Repository
public interface Study_talk_about {
    //展示所有的帖子
    List<School_talk> search_all();

    //发送帖子
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
