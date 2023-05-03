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
import talks.Pojo.S_user_like;
import talks.Pojo.SuserDto;
import talks.Pojo.s_usc;
import talks.Server.s_user_sc_server;
import talks.config.SecurityUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@RestController
@RequestMapping("/talk/sc")
public class user_sc {
    //用户收藏相关
    @Resource
    private s_user_sc_server usc;
    @Resource
    UserClient userClient;
    @Resource
    s_user_sc_server s_user_sc_server;

    //返回用户收藏列表
    @GetMapping("/my_sc")
    public ResultData mysc(){
        List<s_usc> scs = usc.mysc("***");//tid
        //tid查uid

            List<SuserDto> suserDtoList=new ArrayList<>();
            for (s_usc usc1:scs){
                SuserDto suserDto=new SuserDto();
                BeanUtils.copyProperties(usc1,suserDto);
                suserDtoList.add(suserDto);
                //用户
                //tid查到uid
                String tuid = s_user_sc_server.getTuid(usc1.getUsc_sid());
                //
                UserUn userUn = userClient.findUserUn(tuid);
                suserDto.setUser_avatar(userUn.getUserAvatar());
                suserDto.setUser_name(userUn.getUserName());
            }
//        System.out.println("=========================================="+userUn);
        return new ResultData("200","OK!",suserDtoList);
    }

    //用户收藏帖子
    @PostMapping("/addsc")
    public ResultData add_user_sc(@RequestBody s_usc s_usc){
        Integer f =  usc.user_sc(s_usc);
        if(f == 200){
        return new ResultData("200","OK!",f);
        }
        else return new ResultData("600","OK!","请检查您的参数或者其他内容！");
    }

    //删除用户的收藏帖子
    @GetMapping("/delsc")
    public ResultData del_user_sc(@RequestParam("sid") String sid){
        Integer f =  usc.user_dis_sc(sid);
        if(f == 200){
            return new ResultData("200","OK!","删除成功！");
        }
        else return new ResultData("600","OK!","请检查您的参数或者其他内容！");
    }

    //判断是都收藏过
    @GetMapping("/issc")
    public ResultData issc(@RequestParam("usc_sid") String usc_sid)
    {
        s_usc uscs = usc.issc(usc_sid);
        if (uscs != null){
            return new ResultData("200","已经收藏!",uscs);
        }else {
            return new ResultData("201","没有收藏!","");
        }
    }

}
