package com.simon.ss.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Jiajie.Mao
 * @date 2019/9/11 13:32
 **/
@Data
@TableName("t_order_item")
public class OrderItem  implements Serializable {

    @TableField("order_item_id")
    @TableId
    private Long orderItemId;

    @TableField("order_id")
    private Long orderId;

    @TableField("user_id")
    private Long userId;

    @TableField("product_code")
    private String productCode;

    private Double amount;

    private String remark;


}

