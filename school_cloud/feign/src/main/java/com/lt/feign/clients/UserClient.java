package com.lt.feign.clients;


import com.lt.feign.pojo.UserUn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "school-user")
public interface UserClient {

    @GetMapping("/user/open/getusernu/{id}")
    UserUn findUserUn(@PathVariable("id") String id);
}
