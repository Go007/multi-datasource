package com.hong.template1.service.db2.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hong.template1.entity.CrClearingEntity;
import com.hong.template1.mapper.CrClearingMapper;
import com.hong.template1.service.db2.ICrClearingService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author wanghong
 * @Date 2020/9/29 13:45
 * @Version V1.0
 **/
@Service
public class CrClearingServiceImpl extends ServiceImpl<CrClearingMapper, CrClearingEntity> implements ICrClearingService {
    @Override
    public CrClearingEntity getEntity(Long id) {
        return getById(id);
    }
}
