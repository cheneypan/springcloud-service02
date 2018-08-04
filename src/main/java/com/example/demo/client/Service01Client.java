package com.example.demo.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cheney on 2018/8/5.
 */
@FeignClient(name = "service01")
public interface Service01Client {

    @RequestMapping(value="/reply",method = RequestMethod.GET)
    String reply(@RequestParam("message") String message);

}
