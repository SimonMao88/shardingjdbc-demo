package com.simon.ss.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@TableName("t_order")
public class Order extends Model<Order> {

    @TableField("order_id")
    @TableId
    private Long orderId;

    @TableField("user_id")
    private Long userId;

    private Double amount;

    private String remark;

}