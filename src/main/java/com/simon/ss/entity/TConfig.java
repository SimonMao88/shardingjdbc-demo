package com.simon.ss.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Jiajie.Mao
 * @date 2019/9/11 13:34
 **/
@Data
public class TConfig implements Serializable {

    private Integer id;
    private Long userId;
    private String config;

}
