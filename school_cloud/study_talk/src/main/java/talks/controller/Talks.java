package talks.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import talks.Pojo.ResultData;
import talks.Pojo.STk;
import talks.Pojo.School_talk;
import talks.Server.Del_talk_server;
import talks.Server.Imp.Search_talk_serverImp;
import talks.Server.School_talk_server;
import talks.Server.Up_talk_Server;
import talks.mapper.Testmapper;

import javax.annotation.Resource;
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
@RequestMapping("/school")
public class Talks {
    @Resource
    private Testmapper tests;
    @Resource
    private School_talk_server schoolTalkServer;
    @Resource
    private Del_talk_server delTalkServer;
    @Resource
    private Up_talk_Server upTalkServer;
    @Resource
    private Search_talk_serverImp searchTalkServerImp;

    @GetMapping("/lists")
    public List<STk> findalllist(){
        List<STk> list =tests.findalltk();
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
        int x=schoolTalkServer.addtalk(schoolTalk);
        if(x==1){
            ResultData resultData = new ResultData("200","OK!","增加成功!");
            return resultData;
        }else {
            ResultData resultData = new ResultData("600","error!","请检查您的参数或者其他内容!");
            return resultData;
        }
    }
    //删除帖子按照帖子ID删除
    @GetMapping("/deltalk")
    public ResultData deltalk(@RequestParam("t_id") String tid){
        int f = delTalkServer.deltalk(tid);
        if (f == 1){
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
        int f = upTalkServer.uptalk(schoolTalk);
        if(f == 1){
            ResultData resultData1 = new ResultData("200","OK!","修改成功!");
            return resultData1;
        }else{
            ResultData resultData2 = new ResultData("600","error!","请检查您的参数或者其他内容！");
            return resultData2;
        }
    }
    //按照帖子内容去查询帖子（支持模糊匹配）‘
    @GetMapping("/search_source")
    private ResultData search_source(@RequestParam("source") String source){
         School_talk schoolTalk = searchTalkServerImp.search_talk_source(source);
         if (schoolTalk != null){
             ResultData resultData1 = new ResultData("200","OK!",schoolTalk);
             return resultData1;
         }
         else {
             ResultData resultData2 = new ResultData("600","error!","请检查您的参数或者其他内容");
             return resultData2;
         }
    }
}
