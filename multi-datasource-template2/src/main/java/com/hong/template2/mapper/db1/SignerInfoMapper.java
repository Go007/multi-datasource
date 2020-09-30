package com.hong.template2.mapper.db1;

import com.hong.template2.entity.SignerInfo;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 签约人信息 Mapper 接口
 * </p>
 *
 * @author wanghong
 * @since 2020-04-20
 */
@Repository
public interface SignerInfoMapper  {

    SignerInfo getOne(Long id);

}
