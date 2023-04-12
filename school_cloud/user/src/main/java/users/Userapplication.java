package users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname Userapplication
 * @Description TODO
 * @Date 2023/4/4 11:09
 * @Created by wang
 */
@SpringBootApplication
public class Userapplication {
    public static void main(String[] args) {
        SpringApplication.run(Userapplication.class,args);
    }
}
