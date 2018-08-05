package com.example.demo.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cheney on 2018/8/5.
 */
@FeignClient(serviceId = "service01", fallbackFactory = Service01Client.Service01ClientFallback.class)
public interface Service01Client {

    @RequestMapping(value="/reply",method = RequestMethod.GET)
    String reply(@RequestParam("message") String message);

    @Component
    class Service01ClientFallback implements Service01Client {

        private Logger logger = LoggerFactory.getLogger(getClass());

        @Override
        public String reply(@RequestParam("message") String message) {
            logger.error("ERROR: param[message = {}]", message);
            String reply = "ERROR -> " + message;
            return reply;
        }
    }

}
