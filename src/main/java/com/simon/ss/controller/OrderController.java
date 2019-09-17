package com.simon.ss.controller;

import com.simon.ss.dao.OrderMapper;
import com.simon.ss.entity.Order;
import com.simon.ss.params.OrderRequestBody;
import com.simon.ss.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author Jiajie.Mao
 * @date 2019/9/11 13:53
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Object selectById(@RequestParam("orderId") Long orderId){
        return orderService.selectById(orderId);
    }

    @RequestMapping(value = "/getDetailById", method = RequestMethod.GET)
    public Object selectDetailById(@RequestParam("orderId") Long orderId){
        return orderService.selectDetailById(orderId);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Object queryAll(){
        return orderService.queryAll();
    }

    @PostMapping(value = "/add")
    public Boolean insert(@RequestBody OrderRequestBody body){
        return orderService.insert(body);
    }


}
