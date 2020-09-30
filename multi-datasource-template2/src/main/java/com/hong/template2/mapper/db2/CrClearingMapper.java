package com.hong.template2.mapper.db2;

import com.hong.template2.entity.CrClearingEntity;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author wanghong
 * @Date 2020/9/29 13:43
 * @Version V1.0
 **/
@Repository
public interface CrClearingMapper {

    CrClearingEntity getOne(Long id);

}
