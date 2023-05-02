package help_sove.controller;

import help_sove.pojo.R;
import help_sove.pojo.po.HelpSove;
import help_sove.service.HelpSoveService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private HelpSoveService helpSoveService;

    //解决
    @PostMapping("/open/solve")
    public R<String> Solve(@RequestBody HelpSove helpSove){
        System.out.println("==========================");
        System.out.println(helpSove.getHState());
        System.out.println(helpSove.getHId());
        System.out.println(helpSove.getHSoveperson());
        System.out.println(helpSove.getHSFa());
        helpSoveService.Solve(helpSove);
        return R.success("ok");
    }

    //查询我的解决方案
    @GetMapping("/getMySolve")
    public R<List<HelpSove>> getMySolve(){
        List<HelpSove> mySolve = helpSoveService.getMySolve();
        return R.success(mySolve);
    }

    //查询所有的解决方案
    @GetMapping("/open/getAllSolve")
    public R<List<HelpSove>> getAllSolve(){
        List<HelpSove> allSolve = helpSoveService.getAllSolve();
        return R.success(allSolve);
    }
}
