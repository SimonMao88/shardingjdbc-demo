package com.simon.ss.controller;

import com.simon.ss.dao.TConfigMapper;
import com.simon.ss.entity.TConfig;
import com.simon.ss.params.OrderRequestBody;
import com.simon.ss.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author Jiajie.Mao
 * @date 2019/9/11 13:53
 **/
@RestController
@RequestMapping("/config")
public class TConfigController {

    @Autowired
    private TConfigMapper tConfigMapper;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Object queryAll(){
        return tConfigMapper.queryAll();
    }

    @PostMapping(value = "/add")
    public Object insert(@RequestBody TConfig body){
        return tConfigMapper.insert(body);
    }


}
