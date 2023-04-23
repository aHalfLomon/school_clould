package help_sove.controller;

import help_sove.pojo.HelpImg;
import help_sove.pojo.ResultData;
import help_sove.service.Help_ImgServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import javax.annotation.Resource;

/**
 * @Classname Help_Img
 * @Date 2023/4/13 17:07
 * @Created by wang
 */

@SpringBootApplication
@EnableDiscoveryClient
@CrossOrigin
@EnableWebMvc
@RestController
@RequestMapping("/helptalk/help_img")
public class Help_Img {
    @Resource
    private Help_ImgServer helpImgServer;

    @PostMapping("/addimg")
    public ResultData addimg(@RequestBody HelpImg helpImg){
        helpImgServer.addImg(helpImg);
        return new ResultData("200","test","cehsi");
    }

    @GetMapping("/delimg")
    public ResultData delimg(@RequestParam("h_img_sid") String id,@RequestParam("h_img") String h_img){
        helpImgServer.delImg(id,h_img);
        return new ResultData("200","test","cehsi");
    }


}
