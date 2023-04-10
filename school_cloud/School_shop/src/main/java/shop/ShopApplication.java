package shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname shop.ShopApplication
 * @Date 2023/4/10 11:50
 * @Created by wang
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class,args);
    }
}
