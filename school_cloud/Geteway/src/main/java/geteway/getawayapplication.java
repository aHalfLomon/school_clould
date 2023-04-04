package geteway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname getawayapplication
 * @Description TODO
 * @Date 2023/4/4 11:06
 * @Created by wang
 */
@SpringBootApplication
@EnableDiscoveryClient
public class getawayapplication {
    public static void main(String[] args) {
        SpringApplication.run(getawayapplication.class,args);
    }
}
