package help_sove.mapper;

import help_sove.pojo.HlepMess;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface HelpmessMapper {
    Integer addHelpmess(HlepMess helpMess);

    Integer delHelpmess(String h_id);

    Integer uphelpless(HlepMess helpMess);
}
