package com.simon.ss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simon.ss.dto.OrderDto;
import com.simon.ss.entity.Order;
import com.simon.ss.params.OrderRequestBody;

import java.util.List;

/**
 * @author Jiajie.Mao
 * @date 2019/9/16 9:59
 **/
public interface OrderService extends IService<Order>{

    Order selectById(Long orderId);

    OrderDto selectDetailById(Long orderId);

    List<OrderDto> queryAll();

    Boolean insert(OrderRequestBody body);
}
