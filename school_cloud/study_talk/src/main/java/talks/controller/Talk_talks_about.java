package talks.controller;

import com.lt.feign.clients.UserClient;
import com.lt.feign.pojo.UserUn;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import talks.Pojo.ResultData;
import talks.Pojo.Stu_talks;
import talks.Pojo.Talk_Talk_likes;
import talks.Pojo.Talk_talks;
import talks.Server.Talk_talk_likeserver;
import talks.Server.Talk_talk_server;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@RestController
@RequestMapping("/talk/talk_talk")
public class Talk_talks_about {

    //评论相关
    @Resource
    private Talk_talk_server talkTalkServer;

    @Resource
    private Talk_talk_likeserver talkLikeserver;

    @Resource
    UserClient userClient;


    @PostMapping("/addtalk")
    public ResultData addtalks(@RequestBody Talk_talks talk){
        int f = talkTalkServer.addtalk_talk(talk);
        if(f != -1){
            return new ResultData("200","OK","评论成功!");
        }else
            return new ResultData("600","error!","请检查您的参数或者其他内容");
    }

    @GetMapping("/deltalk")
    public ResultData deltalk(@RequestParam("tk_id") String tk_id){
        int f = talkTalkServer.del_talk_talk(tk_id);
        if(f != -100){
            return new ResultData("200","OK","删除评论成功!");
        }else
            return new ResultData("600","error!","请检查您的参数或者该用户没有删除权限！");
    }

    @GetMapping("/open/takl_talks")
    public ResultData takl_talks(@RequestParam("tk_tid") String tk_id){
        List<Talk_talks> f = talkTalkServer.Talks_talks(tk_id);
        if(f != null){
            List<Stu_talks> stu_talks = new ArrayList<>();
            for(Talk_talks talks: f)
            {
                Stu_talks stuTalks = new Stu_talks();
                BeanUtils.copyProperties(talks,stuTalks);
                stu_talks.add(stuTalks);
                UserUn userUn = userClient.findUserUn(talks.getTk_uid());
                stuTalks.setUser_name(userUn.getUserName());
                stuTalks.setUser_avatar(userUn.getUserAvatar());
            }
            return new ResultData("200","OK",stu_talks);
        }else
            return new ResultData("201","OK","当前帖子可能还没有评论哦");
    }

    //---------------------------------------------以下是评论的点赞相关
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
