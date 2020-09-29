package com.hong.service.db2;

import com.hong.entity.CrClearingEntity;
import com.hong.mapper.CrClearingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author wanghong
 * @Date 2020/9/29 14:51
 * @Version V1.0
 **/
@Service
public class CrClearingService {

    @Autowired
    private CrClearingMapper crClearingMapper;

    public CrClearingEntity getOne(Long id){
        return crClearingMapper.selectById(id);
    }

}
