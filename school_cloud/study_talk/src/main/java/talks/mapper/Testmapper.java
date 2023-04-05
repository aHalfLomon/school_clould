package talks.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import talks.Pojo.STk;
import talks.Pojo.TestPojo;

import java.util.List;

/**
 * @Classname testmapper
 * @Description TODO
 * @Date 2023/4/5 11:43
 * @Created by wang
 */
@Mapper
@Repository
public interface Testmapper {
    @Select("SELECT * FROM s_tk")
    List<STk> findalltk();
}
