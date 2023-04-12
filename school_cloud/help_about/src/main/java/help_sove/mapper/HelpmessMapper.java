package help_sove.mapper;

import help_sove.pojo.HlepMess;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface HelpmessMapper {
    Integer addHelpmess(HlepMess helpMess);

    @Delete("DELETE FROM hlep_mess where h_id = #{h_id}")
    Integer delHelpmess(String h_id);

    Integer uphelpless(HlepMess helpMess);
}
