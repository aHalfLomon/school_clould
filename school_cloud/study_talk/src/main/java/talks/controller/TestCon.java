package talks.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import talks.Pojo.STk;
import talks.Pojo.School_talk;
import talks.Server.School_talk_server;
import talks.mapper.Testmapper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
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
public class TestCon {
    @Resource
    private Testmapper tests;
    @Resource
    private School_talk_server schoolTalkServer;

    @GetMapping("/lists")
    public List<STk> findalllist(){
        List<STk> list =tests.findalltk();
        return list;
    }
    @PostMapping("/addtalk")
    public  List<Integer> addtalk(School_talk schoolTalk)
//            @RequestParam("tid") String tid
//    ,@RequestParam("uid") String uid
//    ,@RequestParam("timg")String t_img
//    ,@RequestParam("tsource") String source
//                                  ,@RequestParam("date") Date t_date)
    {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
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
        schoolTalkServer.addtalk(schoolTalk);
        return list1;
    }

}
