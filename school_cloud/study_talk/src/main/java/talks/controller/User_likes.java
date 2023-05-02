package talks.controller;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import talks.Pojo.ResultData;
import talks.Pojo.S_user_like;
import talks.Server.s_user_like_server;
import talks.mapper.S_uesr_likes;
import talks.mapper.s_user_like;

import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@RestController
@RequestMapping("/talk/likes")
public class User_likes {

    @Resource
    private s_user_like_server likeServer;

    //返回用户的点赞；列表
    @GetMapping("/my_likes")
    public ResultData mylikes(){
        List<S_user_like> mylikes = likeServer.mylike("***");
        return new ResultData("200","OK!",mylikes);
    }


    //添加一个收藏
    @PostMapping("/addlike")
    public ResultData addlike(@RequestBody S_user_like Suserlike){
        Integer f = likeServer.user_like(Suserlike);
        return new ResultData("200","OK!",f);
    }

}
