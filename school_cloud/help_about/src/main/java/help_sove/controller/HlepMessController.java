package help_sove.controller;

import help_sove.pojo.R;
import help_sove.pojo.dto.HelpMessDto;
import help_sove.pojo.vo.HelpMessVo;
import help_sove.pojo.vo.UpHelpMessVo;
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
        System.out.println("===========================");
        System.out.println(helpMessVo);
        hlepMessService.addHelp(helpMessVo);
        return R.success("ok");
    }

    //删除我反馈的帖子
    @DeleteMapping("/delMyHelp/{hid}")
    public R<String> delMyHelp(@PathVariable("hid") String hid){
        hlepMessService.delMyHelp(hid);
        return R.success("ok");
    }

    //修改我的反馈
    @PostMapping("/upMyHelp")
    public R<String> upMyHelp(@RequestBody UpHelpMessVo upHelpMessVo){
        hlepMessService.upMyHelp(upHelpMessVo);
        return R.success("ok");
    }

    //查询我反馈的帖子
    @GetMapping("/getMyHelp")
    public R<List<HelpMessDto>> getMyHelp(){
        List<HelpMessDto> myHelp = hlepMessService.getMyHelp();
        return R.success(myHelp);
    }

    //查询所有反馈的帖子
    @GetMapping("/open/getAllHelp")
    public R<List<HelpMessDto>> getAllHelp(){
        List<HelpMessDto> allHelp = hlepMessService.getAllHelp();
        return R.success(allHelp);
    }
}

