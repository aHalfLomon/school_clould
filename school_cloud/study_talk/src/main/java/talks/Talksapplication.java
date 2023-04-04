package talks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname Talksapplication
 * @Description TODO
 * @Date 2023/4/4 16:36
 * @Created by wang
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Talksapplication {
    public static void main(String[] args) {
        SpringApplication.run(Talksapplication.class,args);
    }
}
