package com.ylw.springboot.controller;

import com.ylw.springboot.bean.User;
import com.ylw.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/addCache")
    public String addCache() {
        User user = userMapper.findByName("Dumas");
        if(user == null){
            return "fail";
        }
        return user.toString();
    }

    @RequestMapping("/getCache")
    public String getCache() {
        Cache baseCache = cacheManager.getCache("baseCache");
        if(baseCache == null){
            return "fail";
        }
        return baseCache.getNativeCache().toString();
    }



    @RequestMapping("/removeCache")
    public String removeCache() {
        cacheManager.getCache("baseCache").clear();
        return "success";
    }


}
