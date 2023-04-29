package talks.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import talks.Pojo.ResultData;
import talks.Pojo.s_usc;
import talks.Server.s_user_sc_server;
import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@RestController
@CrossOrigin
@RequestMapping("/talk/sc")
public class user_sc {
    //用户收藏相关
    @Resource
    private s_user_sc_server usc;

    //返回用户收藏列表
    @GetMapping("/my_sc")
    public ResultData mysc(@RequestParam("uid") String uid){
        List<s_usc> scs = usc.mysc(uid);
        return new ResultData("200","OK!",scs);
    }

    //用户收藏帖子
    @PostMapping("/addsc")
    public ResultData add_user_sc(@RequestBody s_usc s_usc){
        Integer f =  usc.user_sc(s_usc);
        return new ResultData("200","OK!",f);
    }

    //删除用户的收藏帖子
    @GetMapping("/delsc")
    public ResultData del_user_sc(@RequestParam("usc_sid") String sid,@RequestParam("usc_uid") String uid){
        Integer f =  usc.user_dis_sc(sid,uid);
        return new ResultData("200","OK!",f);
    }

}
