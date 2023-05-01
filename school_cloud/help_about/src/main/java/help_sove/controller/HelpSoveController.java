package help_sove.controller;

import help_sove.pojo.R;
import help_sove.pojo.po.HelpSove;
import help_sove.service.HelpSoveService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname Help_sove
 * @Description TODO
 * @Date 2023/4/13 17:07
 * @Created by wang
 */


@RestController
@RequestMapping("/help")
public class HelpSoveController {
    @Resource
    private HelpSoveService helpSove;

    //解决
    @PostMapping("/solve")
    public R<String> Solve(@RequestBody HelpSove helpSove){
        return R.success("ok");
    }

    //解决不了
    @PostMapping("/nosolve")
    public R<String> NoSolve(@RequestBody HelpSove helpSove){
        return R.success("ok");
    }

    //查询我的解决方案
    @GetMapping("/getMySolve")
    public R<List<HelpSove>> getMySolve(){
        return R.success(null);
    }

    //查询所有的解决方案
    @GetMapping("/getAllSolve")
    public R<List<HelpSove>> getAllSolve(){
        return R.success(null);
    }
}
