package talks.controller;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import talks.Pojo.IsUsersc;
import talks.Pojo.ResultData;
import talks.Pojo.S_user_like;
import talks.Pojo.s_usc;
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


    //添加一个    @PostMapping("/addlike")
    public ResultData addlike(@RequestBody S_user_like Suserlike){
        Integer f = likeServer.user_like(Suserlike);
        if (f == 200){
            return new ResultData("200","OK!","喜欢成功！");
        }else {
            return new ResultData("600","ERROR!","请检查您的参数！");
        }
    }

    @GetMapping("/dislike")
    public ResultData dislike(@RequestParam("like_tid") String tid)
    {
        Integer f = likeServer.userdislinke(tid);
        if (f == 200){
            return new ResultData("200","OK!","取消喜欢成功！");
        }else {
            return new ResultData("600","ERROR!","请检查您的参数！");
        }

    }

    //判断用户是否收藏过
    @PostMapping("/open/islike")
    public ResultData islike(@RequestBody IsUsersc isUsersc0)
    {
        //S_user_like sUserLike = likeServer.islike(tid);
//        if (sUserLike != null){
//            return new ResultData("200","已经点赞!",sUserLike);
//        }else {
//            return new ResultData("201","没有点赞!","");
//        }

        IsUsersc isUsersc1 = new IsUsersc();

        if (!isUsersc0.getT1().equals("null"))
        {
            S_user_like like = likeServer.islike(isUsersc0.getT1());
            if(like != null)
                isUsersc1.setT1("已点赞");
            else {
                isUsersc1.setT1("未点赞");
            }
        }else isUsersc1.setT1("null");

        if (!isUsersc0.getT2().equals("null"))
        {
            S_user_like like2 = likeServer.islike(isUsersc0.getT2());
            if(like2!= null)
                isUsersc1.setT2("已点赞");
            else {
                isUsersc1.setT2("未点赞");
            }
        }else isUsersc1.setT2("null");

        if (!isUsersc0.getT3().equals("null"))
        {
            S_user_like like3 = likeServer.islike(isUsersc0.getT3());
            if(like3!= null)
                isUsersc1.setT3("已点赞");
            else {
                isUsersc1.setT3("未点赞");
            }
        }else isUsersc1.setT3("null");

        if (!isUsersc0.getT4().equals("null"))
        {
            S_user_like like4 = likeServer.islike(isUsersc0.getT4());
            if(like4!= null)
                isUsersc1.setT4("已点赞");
            else {
                isUsersc1.setT4("未点赞");
            }
        }else isUsersc1.setT4("null");

        if (!isUsersc0.getT5().equals("null"))
        {
            S_user_like like5 = likeServer.islike(isUsersc0.getT5());
            if(like5!= null)
                isUsersc1.setT5("已点赞");
            else {
                isUsersc1.setT5("未点赞");
            }
        }else isUsersc1.setT5("null");

        if (!isUsersc0.getT6().equals("null"))
        {
            S_user_like like6 = likeServer.islike(isUsersc0.getT6());
            if(like6!= null)
                isUsersc1.setT6("已点赞");
            else {
                isUsersc1.setT6("未点赞");
            }
        }else isUsersc1.setT6("null");
        if (!isUsersc0.getT7().equals("null"))
        {
            S_user_like like7 = likeServer.islike(isUsersc0.getT7());
            if(like7 != null)
                isUsersc1.setT7("已点赞");
            else {
                isUsersc1.setT7("未点赞");
            }
        }else isUsersc1.setT7("null");

        if (!isUsersc0.getT8().equals("null"))
        {
            S_user_like like8 = likeServer.islike(isUsersc0.getT8());
            if(like8!= null)
                isUsersc1.setT8("已点赞");
            else {
                isUsersc1.setT8("未点赞");
            }
        }else isUsersc1.setT8("null");

        return new ResultData("200","ok!",isUsersc1);
    }
}
