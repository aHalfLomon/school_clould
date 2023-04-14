package help_sove.mapper;

import help_sove.pojo.HlepMess;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HelpmessMapper {

    List<HlepMess> allmessages();
    Integer addHelpmess(HlepMess helpMess);

    @Delete("DELETE FROM help_mess where h_id = #{h_id}")
    Integer delHelpmess(String h_id);

    Integer uphelpless(HlepMess helpMess);
}
