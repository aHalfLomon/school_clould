package help_sove.controller;

import help_sove.pojo.R;
import help_sove.pojo.dto.HelpMessDto;
import help_sove.pojo.vo.HelpMessVo;
import help_sove.service.HlepMessService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/help")
public class HlepMessController {

    @Resource
    HlepMessService hlepMessService;

    //增加一条反馈的帖子
    @PostMapping("/addHelp")
    public R<String> addHelp(@RequestBody HelpMessVo helpMessVo){
        return R.success("ok");
    }

    //删除我反馈的帖子
    @DeleteMapping("/delMyHelp/{id}")
    public R<String> delMyHelp(@PathVariable("id") String id){
        return R.success("ok");
    }

    //修改我的反馈
    @PostMapping("/upMyHelp/{id}")
    public R<String> upMyHelp(@RequestBody HelpMessVo helpMessVo){
        return R.success("ok");
    }

    //查询我反馈的帖子
    @PostMapping("/getMyHelp")
    public R<List<HelpMessDto>> getMyHelp(){
        return R.success(null);
    }

    //查询所有反馈的帖子
    @PostMapping("/getAllHelp")
    public R<List<HelpMessDto>> getAllHelp(){
        return R.success(null);
    }
}

