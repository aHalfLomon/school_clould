package help_sove;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname Help_aboutApplication
 * @Date 2023/4/11 10:33
 * @Created by w
 * ang
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Help_aboutApplication {
    public static void main(String[] args) {
        SpringApplication.run(Help_aboutApplication.class,args);
    }
}
