package com.simon.ss.dao;

import com.simon.ss.entity.TConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jiajie.Mao
 * @date 2019/9/16 10:45
 **/
@Repository
public interface TConfigMapper {

    List<TConfig> queryAll();

    TConfig insert(TConfig config);
}
