package help_sove.service;

import help_sove.pojo.HlepMess;
import org.springframework.stereotype.Service;

/**
 * (HlepMess)表服务接口
 *
 * @author makejava
 * @since 2023-04-11 11:37:12
 */
@Service
public interface HlepMessService {

    Integer addHelpmess(HlepMess helpMess);

    Integer delHelpmess(String h_id);

    Integer uphelpless(HlepMess helpMess);

}