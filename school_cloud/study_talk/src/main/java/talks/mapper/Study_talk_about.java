package talks.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import talks.Pojo.School_talk;
import talks.Pojo.Talk_talks;

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

    //返回用户发布的帖子
    List<School_talk> mytalk(String uid);

    Integer linkit(String t_id);
    //分类相关
    List<School_talk> Life();
    List<School_talk> Study();
    List<School_talk> Food();
    List<School_talk> Fun();
    List<School_talk> Others();

    //用于对主表中的点赞和收藏数进行操作
    Integer addcount(String t_id);
    Integer disaddcount(String t_id);
    Integer addlike(String t_id);
    Integer disaddlike(String t_id);


}
