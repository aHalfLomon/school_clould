package help_sove.controller;

import help_sove.mapper.HelpmessMapper;
import help_sove.pojo.HlepMess;
import help_sove.pojo.ResultData;
import help_sove.service.HlepMessService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@RestController
@RequestMapping("/help_mess")
public class HlepMessController {

    @Resource
    HlepMessService hlepMessService;

    @PostMapping("/add_help")
    public ResultData addHelpMess(@RequestBody HlepMess hlepMess){
        return new ResultData("200","OK!","OK!");
    }

}

