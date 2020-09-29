package com.hong.service.db1.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hong.entity.SignerInfo;
import com.hong.mapper.SignerInfoMapper;
import com.hong.service.db1.ISignerInfoService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author wanghong
 * @Date 2020/9/29 13:37
 * @Version V1.0
 **/
@Service
public class SignerInfoServiceImpl extends ServiceImpl<SignerInfoMapper, SignerInfo> implements ISignerInfoService {

}
