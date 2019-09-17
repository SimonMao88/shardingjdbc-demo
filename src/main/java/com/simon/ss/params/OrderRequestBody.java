package com.simon.ss.params;

import com.simon.ss.entity.OrderItem;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderRequestBody implements Serializable {

    private Long orderId;

    private Long userId;

    private Double amount;

    private String remark;

    private List<OrderItem> items;

}