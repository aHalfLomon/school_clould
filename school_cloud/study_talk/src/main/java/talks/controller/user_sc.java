package talks.controller;

import com.lt.feign.clients.UserClient;
import com.lt.feign.pojo.UserUn;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import talks.Pojo.*;
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
    @PostMapping("/issc")
    public ResultData issc(@RequestBody IsUsersc isUsersc0)
    {IsUsersc isUsersc1 = new IsUsersc();
        if (!isUsersc0.getT1().equals("null"))
        {
            s_usc uscs = usc.issc(isUsersc0.getT1());
            if(uscs!= null)
                isUsersc1.setT1("已收藏");
            else {
                isUsersc1.setT1("未收藏");
            }
        }else isUsersc1.setT1("null");

        if (!isUsersc0.getT2().equals("null"))
        {
            s_usc uscs2 = usc.issc(isUsersc0.getT2());
            if(uscs2!= null)
                isUsersc1.setT2("已收藏");
            else {
                isUsersc1.setT2("未收藏");
            }
        }else isUsersc1.setT2("null");

        if (!isUsersc0.getT3().equals("null"))
        {
            s_usc uscs3 = usc.issc(isUsersc0.getT3());
            if(uscs3!= null)
                isUsersc1.setT3("已收藏");
            else {
                isUsersc1.setT3("未收藏");
            }
        }else isUsersc1.setT3("null");

        if (!isUsersc0.getT4().equals("null"))
        {
            s_usc uscs4 = usc.issc(isUsersc0.getT4());
            if(uscs4!= null)
                isUsersc1.setT4("已收藏");
            else {
                isUsersc1.setT4("未收藏");
            }
        }else isUsersc1.setT4("null");

        if (!isUsersc0.getT5().equals("null"))
        {
            s_usc uscs5 = usc.issc(isUsersc0.getT5());
            if(uscs5!= null)
                isUsersc1.setT5("已收藏");
            else {
                isUsersc1.setT5("未收藏");
            }
        }else isUsersc1.setT5("null");

        if (!isUsersc0.getT6().equals("null"))
        {
            s_usc uscs6 = usc.issc(isUsersc0.getT6());
            if(uscs6!= null)
                isUsersc1.setT6("已收藏");
            else {
                isUsersc1.setT6("未收藏");
            }
        }else isUsersc1.setT6("null");

        if (!isUsersc0.getT7().equals("null"))
        {
            s_usc uscs7 = usc.issc(isUsersc0.getT7());
            if(uscs7!= null)
                isUsersc1.setT7("已收藏");
            else {
                isUsersc1.setT7("未收藏");
            }
        }else isUsersc1.setT7("null");

        if (!isUsersc0.getT8().equals("null"))
        {
            s_usc uscs8 = usc.issc(isUsersc0.getT8());
            if(uscs8!= null)
                isUsersc1.setT8("已收藏");
            else {
                isUsersc1.setT8("未收藏");
            }
        }else isUsersc1.setT8("null");

        return new ResultData("200","ok!",isUsersc1);

    }

}
