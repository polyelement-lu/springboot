package com.free.web;

import com.free.config.RedisService;
import com.free.model.City;
import com.free.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hc")
public class DemoController {
    @Autowired
    private RedisService redisService;

    @Autowired
    private ICityService cityService;

    @RequestMapping(value = "/demo",method = RequestMethod.POST)
    public String test(){
        boolean xx = redisService.set("1", "redis缓存");
        String s = (String) redisService.get("1");
        System.err.println("xx:"+s);
        return s+":"+xx;
    }
    @RequestMapping(value = "/tb/list",method = RequestMethod.GET)
    public List<City> list(){
        List<City> all = cityService.getAll();
        return all;
    }
}
