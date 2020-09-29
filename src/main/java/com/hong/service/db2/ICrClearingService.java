package com.hong.service.db2;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hong.entity.CrClearingEntity;

/**
 * @Description:
 * @Author wanghong
 * @Date 2020/9/29 13:44
 * @Version V1.0
 **/
public interface ICrClearingService extends IService<CrClearingEntity> {

    CrClearingEntity getEntity(Long id);

}
