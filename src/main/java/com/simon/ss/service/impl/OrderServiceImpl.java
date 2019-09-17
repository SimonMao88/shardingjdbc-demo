package com.simon.ss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simon.ss.dao.OrderItemMapper;
import com.simon.ss.dao.OrderMapper;
import com.simon.ss.dto.OrderDto;
import com.simon.ss.entity.Order;
import com.simon.ss.entity.OrderItem;
import com.simon.ss.params.OrderRequestBody;
import com.simon.ss.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiajie.Mao
 * @date 2019/9/16 10:00
 **/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper,Order> implements OrderService{

//    @Autowired
//    private OrderMapper orderMapper;
//
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public Order selectById(Long orderId) {
        //new Wrapper写法
        return baseMapper.selectOne(new QueryWrapper<Order>().eq("order_id",orderId));
    }

    @Override
    public OrderDto selectDetailById(Long orderId) {
        //利用Wrappers的写法
        Order order = baseMapper.selectOne(Wrappers.<Order>query().eq("order_id",orderId));

        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(order.getOrderId());
        orderDto.setUserId(order.getUserId());
        orderDto.setAmount(order.getAmount());
        orderDto.setRemark(order.getRemark());
        //利用Wrappers+lambda的写法
        orderDto.setItems(orderItemMapper.selectList(
                Wrappers.<OrderItem>lambdaQuery().eq(OrderItem::getOrderId,orderId)));

        return orderDto;
    }


    @Override
    public List<OrderDto> queryAll() {

        List<OrderDto> orderDtos = new ArrayList<>();

        List<Order> orders = baseMapper.selectList(Wrappers.lambdaQuery());

        for (Order order : orders) {
            OrderDto orderDto = new OrderDto();
            orderDto.setOrderId(order.getOrderId());
            orderDto.setUserId(order.getUserId());
            orderDto.setAmount(order.getAmount());
            orderDto.setRemark(order.getRemark());
            orderDto.setItems(orderItemMapper.selectList(
                    Wrappers.<OrderItem>lambdaQuery().eq(OrderItem::getOrderId,order.getOrderId())));

            orderDtos.add(orderDto);
        }


        return orderDtos;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insert(OrderRequestBody body) {

        Order order = new Order();
        order.setUserId(body.getUserId());
        order.setAmount(body.getAmount());
        order.setRemark(body.getRemark());
        baseMapper.insert(order);


        List<OrderItem> orderItems = body.getItems();
        for (OrderItem orderItem : orderItems) {
            orderItem.setOrderId(order.getOrderId());
            orderItem.setUserId(order.getUserId());
            orderItemMapper.insert(orderItem);
        }


        return null;
    }
}
