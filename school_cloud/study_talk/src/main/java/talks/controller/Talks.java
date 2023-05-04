package talks.controller;

import com.lt.feign.clients.UserClient;
import com.lt.feign.pojo.UserUn;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import talks.Pojo.ResultData;
import talks.Pojo.SchoolTalks;
import talks.Pojo.Talk_talks;
import talks.Pojo.School_talk;
import talks.Server.Study_talk_about_server;
import talks.mapper.Testmapper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname TestCon
 * @Description TODO
 * @Date 2023/4/5 11:40
 * @Created by wang
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@RestController
@RequestMapping("/talk/study_talk")
public class Talks {
    //帖子相关
    @Resource
    private Testmapper tests;
    @Resource
    private Study_talk_about_server talkAboutServer;
    @Resource
    UserClient userClient;
//
    @GetMapping("/lists")
    public List<Talk_talks> findalllist(){
//        UserUn userUn = userClient.findUserUn("04c4fcbd8f5dd1a9a7aa53e8141a017d");
//        System.out.println("=========================================="+userUn);
        List<Talk_talks> list =tests.findalltk();
        return list;
    }
    //用户发帖，在数据库中创建记录
    @PostMapping("/addtalk")
    public ResultData addtalk(@RequestBody School_talk schoolTalk) {
//        School_talk schoolTalk = new School_talk();
//        schoolTalk.setTId(tid);
//        schoolTalk.setTUid(uid);
//        schoolTalk.setTImg(t_img);
//        schoolTalk.setTSource(source);
//        schoolTalk.setTData(t_date);
//        schoolTalk.setTUscCount(0);
//        schoolTalk.setTLikeCount(0);
//        schoolTalk.setTStatus("正常");
//        schoolTalkServer.addtalk(schoolTalk);
        int x=talkAboutServer.addtalk(schoolTalk);
        if(x==1){
            ResultData resultData = new ResultData("200","OK!","增加成功!");
            return resultData;
        }else {
            ResultData resultData = new ResultData("600","error!","请检查您的参数或者其他内容!");
            return resultData;
        }
    }
    //用户删除帖子按照帖子ID删除
    @GetMapping("/deltalk")
    public ResultData deltalk(@RequestParam("t_id") String tid){
        Integer f = talkAboutServer.deltalk(tid);
        if (f == 200){
            ResultData resultData1 = new ResultData("200","OK!","succeeful!");
            return resultData1;
        }else {
            ResultData resultData2 = new ResultData("600","error!","请检查您的参数或者其他内容！");
            return resultData2;
        }
    }
    //更新用户信息
    @PostMapping("/Uptalk")
    public ResultData uptalk(@RequestBody School_talk schoolTalk){
        Integer f = talkAboutServer.uptalk(schoolTalk);
        if(f == 200){
            ResultData resultData1 = new ResultData("200","OK!","修改成功!");
            return resultData1;
        }
        if (f == -100)  new ResultData("201","拒绝修改","非发帖人员没有权限修改帖子！");
        return new ResultData("600","error!","请检查您的参数或者其他内容！");
    }


    //按照帖子内容去查询帖子（支持模糊匹配）
    @GetMapping("/open/search_source")
    private ResultData search_source(@RequestParam("source") String source){
         List<School_talk> schoolTalk = talkAboutServer.search_talk_source(source);
//         if (schoolTalk != null){
//             ResultData resultData1 = new ResultData("200","OK!",schoolTalk);
//             return resultData1;
//         }else {
//             ResultData resultData2 = new ResultData("600","error!","请检查您的参数或者其他内容");
//             return resultData2;
//         }
        ResultData resultData1 = new ResultData("200","OK!",schoolTalk);
        return resultData1;
    }
    //----------------------------------------------------------------------
    //帖子的点赞数
    @GetMapping("/open/search_talk_like")
    public ResultData search_talk_like(@RequestParam("t_id") String t_id){
        School_talk f = talkAboutServer.talk_like_cont(t_id);
        if(f != null){
            return new ResultData("200","OK!",f);
        }
        else {
            return new ResultData("600","error!","请检查您的参数或者其他内容！");
        }
    }
    //返回帖子的收藏数
    @GetMapping("/open/search_talk_sc")
    public ResultData search_talk_sc(@RequestParam("t_id") String t_id){
        School_talk f = talkAboutServer.talk_usersc_cont(t_id);
        if(f != null){
            return new ResultData("200","OK!",f);
        }
        else {
            return new ResultData("600","error!","请检查您的参数或者其他内容！");
        }
    }

    //来展示所有的帖子
    @GetMapping("/open/all_studyTalk/{p}")
    public ResultData all_studyTalk(@PathVariable("p") int p){
        List<School_talk> talks = talkAboutServer.search_all(p);
        List<SchoolTalks> talks1 = new ArrayList<>();
        for(School_talk talks2 :talks){
            SchoolTalks schoolTalks = new SchoolTalks();
            BeanUtils.copyProperties(talks2,schoolTalks);
            talks1.add(schoolTalks);
            String uuid = talks2.getT_uid();
            UserUn user = userClient.findUserUn(uuid);
            schoolTalks.setLiked(false);
            schoolTalks.setCollent(false);
            schoolTalks.setComment(null);
            schoolTalks.setUser_avatar(user.getUserAvatar());
            schoolTalks.setUser_name(user.getUserName());
        }
        return new ResultData("200","OK!",talks1);
    }

    //展示用户发布的帖子 --------------------------------------------------------------------------------------
    @GetMapping("/mytalks")
    public ResultData allmytalk(){
        List<School_talk> mytalks = talkAboutServer.mytalk("***");
        if (mytalks != null){
            return new ResultData("200","OK!",mytalks);
        }else
        {
            return new ResultData("200","OK!","似乎你还没有发过帖子");
        }
    }
    //分类++++++++++++++++++++++++++++++++++++++++++++++++++++
    @GetMapping("/open/Tlife")
    public ResultData Tlife(){
        List<School_talk> talks = talkAboutServer.Life();
        List<SchoolTalks> talks1 = new ArrayList<>();
        for(School_talk talks2 :talks){
            SchoolTalks schoolTalks = new SchoolTalks();
            BeanUtils.copyProperties(talks2,schoolTalks);
            talks1.add(schoolTalks);
            String uuid = talks2.getT_uid();
            UserUn user = userClient.findUserUn(uuid);
            schoolTalks.setLiked(false);
            schoolTalks.setCollent(false);
            schoolTalks.setComment(null);
            schoolTalks.setUser_avatar(user.getUserAvatar());
            schoolTalks.setUser_name(user.getUserName());
        }
        return new ResultData("200","OK!",talks1);
    }
    @GetMapping("/open/Tfood")
    public ResultData Tfood(){
        List<School_talk> talks = talkAboutServer.Food();
        List<SchoolTalks> talks1 = new ArrayList<>();
        for(School_talk talks2 :talks){
            SchoolTalks schoolTalks = new SchoolTalks();
            BeanUtils.copyProperties(talks2,schoolTalks);
            talks1.add(schoolTalks);
            String uuid = talks2.getT_uid();
            UserUn user = userClient.findUserUn(uuid);
            schoolTalks.setLiked(false);
            schoolTalks.setCollent(false);
            schoolTalks.setComment(null);
            schoolTalks.setUser_avatar(user.getUserAvatar());
            schoolTalks.setUser_name(user.getUserName());
        }
        return new ResultData("200","OK!",talks1);
    }
    @GetMapping("/open/TFun")
    public ResultData TFun(){
        List<School_talk> talks = talkAboutServer.Fun();
        List<SchoolTalks> talks1 = new ArrayList<>();
        for(School_talk talks2 :talks){
            SchoolTalks schoolTalks = new SchoolTalks();
            BeanUtils.copyProperties(talks2,schoolTalks);
            talks1.add(schoolTalks);
            String uuid = talks2.getT_uid();
            UserUn user = userClient.findUserUn(uuid);
            schoolTalks.setLiked(false);
            schoolTalks.setCollent(false);
            schoolTalks.setComment(null);
            schoolTalks.setUser_avatar(user.getUserAvatar());
            schoolTalks.setUser_name(user.getUserName());
        }
        return new ResultData("200","OK!",talks1);
    }
    @GetMapping("/open/Tstudy")
    public ResultData Tstudy(){
        List<School_talk> talks = talkAboutServer.Study();
        List<SchoolTalks> talks1 = new ArrayList<>();
        for(School_talk talks2 :talks){
            SchoolTalks schoolTalks = new SchoolTalks();
            BeanUtils.copyProperties(talks2,schoolTalks);
            talks1.add(schoolTalks);
            String uuid = talks2.getT_uid();
            UserUn user = userClient.findUserUn(uuid);
            schoolTalks.setLiked(false);
            schoolTalks.setCollent(false);
            schoolTalks.setComment(null);
            schoolTalks.setUser_avatar(user.getUserAvatar());
            schoolTalks.setUser_name(user.getUserName());
        }
        return new ResultData("200","OK!",talks1);
    }
    @GetMapping("/open/Tother")
    public ResultData Tother(){
        List<School_talk> talks = talkAboutServer.Others();
        List<SchoolTalks> talks1 = new ArrayList<>();
        for(School_talk talks2 :talks){
            SchoolTalks schoolTalks = new SchoolTalks();
            BeanUtils.copyProperties(talks2,schoolTalks);
            talks1.add(schoolTalks);
            String uuid = talks2.getT_uid();
            UserUn user = userClient.findUserUn(uuid);
            schoolTalks.setLiked(false);
            schoolTalks.setCollent(false);
            schoolTalks.setComment(null);
            schoolTalks.setUser_avatar(user.getUserAvatar());
            schoolTalks.setUser_name(user.getUserName());
        }
        return new ResultData("200","OK!",talks1);
    }
}
