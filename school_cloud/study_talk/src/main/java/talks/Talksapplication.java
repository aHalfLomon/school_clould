package talks;

import com.lt.feign.clients.UserClient;
import com.lt.feign.config.DefaultFeignConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname Talksapplication
 * @Description TODO
 * @Date 2023/4/4 16:36
 * @Created by wang
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(clients = UserClient.class,defaultConfiguration = DefaultFeignConfiguration.class)
public class Talksapplication {
    public static void main(String[] args) {
        SpringApplication.run(Talksapplication.class,args);
    }
}
