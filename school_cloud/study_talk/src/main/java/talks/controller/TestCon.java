package talks.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import talks.Pojo.STk;
import talks.Pojo.TestPojo;
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
public class TestCon {
    @Resource
    private Testmapper tests;

    @GetMapping("/lists")
    public List<STk> findalllist(){
        List<STk> list =tests.findalltk();
        return list;
    }
}
