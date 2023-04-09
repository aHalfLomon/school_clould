package talks.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import talks.Pojo.ResultData;
import talks.Pojo.Talk_Talk_likes;
import talks.Pojo.Talk_talks;
import talks.Server.Talk_talk_likeserver;
import talks.Server.Talk_talk_server;
import javax.annotation.Resource;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@RestController
@RequestMapping("/talk_talk")
public class Talk_talks_about {
    @Resource
    private Talk_talk_server talkTalkServer;

    @Resource
    private Talk_talk_likeserver talkLikeserver;

    @PostMapping("/addtalk")
    public ResultData addtalks(@RequestBody Talk_talks talk){
        int f = talkTalkServer.addtalk_talk(talk);
        if(f != -1){
            return new ResultData("200","OK","添加成功!");
        }else
            return new ResultData("600","error!","请检查您的参数或者其他内容");

    }
    @GetMapping("/deltalk")
    public ResultData deltalk(@RequestParam("tk_id") String tk_id){
        int f = talkTalkServer.del_talk_talk(tk_id);
        if(f != -1){
            return new ResultData("200","OK","删除成功!");
        }else
            return new ResultData("600","error!","请检查您的参数或者其他内容");
    }

    @PostMapping("/like_talk")
    public ResultData like_talk(@RequestBody Talk_Talk_likes talkLikes){
        int f = talkLikeserver.addTalkTalk_like(talkLikes);
        if(f != -1000){
            return new ResultData("200","OK","添加成功!");
        }else{
            return new ResultData("600","error!","请检查您的参数或者其他内容");
        }

    }

    @GetMapping("/dislike_talk")
    public ResultData dislike_talk(@RequestParam("like_sid") String like_sid){
        int f = talkLikeserver.dislike_talk_talk(like_sid);
        if (f!= -1000){
            return new ResultData("200","OK","取消喜欢成功!");
        }else {
            return new ResultData("600","error!","请检查您的参数或者其他内容");
        }


    }


}
