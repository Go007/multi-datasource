package com.hong.service.db1;

import com.hong.entity.SignerInfo;
import com.hong.mapper.SignerInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author wanghong
 * @Date 2020/9/29 14:50
 * @Version V1.0
 **/
@Service
public class SignerInfoService {

    @Autowired
    private SignerInfoMapper signerInfoMapper;

    public SignerInfo getOne(Long id){
        return signerInfoMapper.selectById(id);
    }

}
