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
        int f = hlepMessService.addHelpmess(hlepMess);
        if(f == 1){
            return new ResultData("200","OK!","添加成功!");
        }
        else {
            return new ResultData("600","error!","请检查您的参数或者其他内容");
        }
    }

    @PostMapping("/upHelp_mess")
    public ResultData upmess(@RequestBody HlepMess hlepMess){
        int f = hlepMessService.uphelpless(hlepMess);
        if(f == 1){
            return new ResultData("200","OK!","更新完成!");
        }else {
            return new ResultData("600","error!","请检查您的参数或者其他内容");
        }

    }

    @GetMapping("/del_helpMess")
    public ResultData del_helpMess(@RequestParam("h_id") String h_id){
        int f = hlepMessService.delHelpmess(h_id);
        if(f == 1){
            return new ResultData("200","OK!","删除成功!");
        }else {
            return new ResultData("600","error!","请检查您的参数或者其他内容");
        }

    }

}

