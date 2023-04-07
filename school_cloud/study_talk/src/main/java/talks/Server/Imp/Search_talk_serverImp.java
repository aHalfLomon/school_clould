package talks.Server.Imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talks.Pojo.School_talk;
import talks.Server.Search_talk_server;
import talks.mapper.Search_talk;

import javax.annotation.Resource;

/**
 * @Classname Search_talk_serverImp
 * @Description TODO
 * @Date 2023/4/7 10:36
 * @Created by wang
 */
@Service
@Transactional
public class Search_talk_serverImp implements Search_talk_server{
    @Resource
    private Search_talk search_talk;
    @Override
    public School_talk search_talk_source(String source) {
        try {
            return search_talk.search_talk_source(source);
        }catch (Exception e){
            return null;
        }
    }
}
