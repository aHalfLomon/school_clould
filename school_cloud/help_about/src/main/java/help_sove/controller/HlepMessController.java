package help_sove.controller;

import help_sove.service.HlepMessService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/help_mess")
public class HlepMessController {

    @Resource
    HlepMessService hlepMessService;
    //增加一条反馈的帖子

    //查询我反馈的帖子

    //删除我反馈的帖子


}

