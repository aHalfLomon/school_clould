package talks.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import talks.Pojo.School_talk;

@Mapper
public interface Talkabout extends BaseMapper<School_talk> {
}
