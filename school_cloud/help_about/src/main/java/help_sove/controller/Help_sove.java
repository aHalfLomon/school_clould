package help_sove.controller;

import help_sove.pojo.HelpSove;
import help_sove.pojo.ResultData;
import help_sove.service.Help_sove_Server;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;

/**
 * @Classname Help_sove
 * @Description TODO
 * @Date 2023/4/13 17:07
 * @Created by wang
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@CrossOrigin
@RestController
@RequestMapping("/helptalk/help_sove")
public class Help_sove {
    @Resource
    private Help_sove_Server helpSove;

    @PostMapping("/soveit")
    public ResultData sovrit(@RequestBody HelpSove sove){
        helpSove.soveit(sove);
        return new ResultData("200","null","null");
    }

    @GetMapping("/nosoveit")
    public ResultData nosovrit(@RequestParam("h_sid") String hsid){
        helpSove.nosoveit(hsid);
        return new ResultData("200","null","null");
    }

}
