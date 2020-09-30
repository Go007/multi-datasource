package com.hong.template2;

import com.hong.template2.entity.CrClearingEntity;
import com.hong.template2.entity.SignerInfo;
import com.hong.template2.mapper.db1.SignerInfoMapper;
import com.hong.template2.mapper.db2.CrClearingMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author wanghong
 * @Date 2020/9/29 13:48
 * @Version V1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiDataSourceTest {

    @Autowired
    private CrClearingMapper crClearingMapper;

    @Autowired
    private SignerInfoMapper signerInfoMapper;

    @Test
    public void testMulti() {
        CrClearingEntity crClearingEntity = crClearingMapper.getOne(1L);
        System.out.println(crClearingEntity);
        SignerInfo signerInfo = signerInfoMapper.getOne(5L);
        System.out.println(signerInfo);
    }

}
