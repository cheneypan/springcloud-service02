package com.example.demo.controller;

import com.example.demo.client.Service01Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cheney on 2018/8/5.
 */
@RestController
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

    @Autowired
    private Service01Client service01Client;

    @GetMapping("")
    public String hello(String name) {
        logger.info("name = {}", name);
        if (null == name || name.trim().equals("")) {
            return String.format("[%s]the name is null", df.format(new Date()));
        }
        String reply = String.format("reply from service01: %s", service01Client.reply(name));
        logger.info("name = {}, service01 reploy: {}", name, reply);
        return reply;
    }
}
