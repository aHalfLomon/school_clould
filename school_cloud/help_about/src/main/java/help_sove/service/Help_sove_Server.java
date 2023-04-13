package help_sove.service;

import help_sove.pojo.HelpSove;
import org.springframework.stereotype.Service;

/**
 * @Classname Help_sove_Server
 * @Date 2023/4/13 16:40
 * @Created by wang
 */

@Service
public interface Help_sove_Server {
    Integer soveit(HelpSove helpSove);

    Integer nosoveit(String h_id);
}
