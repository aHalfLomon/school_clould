package help_sove;

import com.lt.feign.clients.UserClient;
import com.lt.feign.config.DefaultFeignConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname Help_aboutApplication
 * @Date 2023/4/11 10:33
 * @Created by w
 * ang
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(clients = UserClient.class,defaultConfiguration = DefaultFeignConfiguration.class)
public class Help_aboutApplication {
    public static void main(String[] args) {
        SpringApplication.run(Help_aboutApplication.class,args);
    }
}
