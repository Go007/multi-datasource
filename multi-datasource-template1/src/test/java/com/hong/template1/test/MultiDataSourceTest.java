package com.hong.template1.test;

import com.hong.template1.entity.CrClearingEntity;
import com.hong.template1.entity.SignerInfo;
import com.hong.template1.service.db1.ISignerInfoService;
import com.hong.template1.service.db1.SignerInfoService;
import com.hong.template1.service.db2.CrClearingService;
import com.hong.template1.service.db2.ICrClearingService;
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
    private ICrClearingService crClearingServiceImpl;

    @Autowired
    private ISignerInfoService signerInfoServiceImpl;

    @Autowired
    private CrClearingService crClearingService;

    @Autowired
    private SignerInfoService signerInfoService;

    /**
     * TODO 数据源动态切换失效
     * 使用了Mybatis-plus,且service层 extends IService 和  extends ServiceImpl,
     * 当调用的方法为Mybatis-plus提供的模板方法时,数据源动态切换失效,需自己方法
     */
    @Test
    public void testMulti(){
        //CrClearingEntity crClearingEntity = crClearingServiceImpl.getById(1); //使用模板方法,数据源切换失效
        CrClearingEntity crClearingEntity = crClearingServiceImpl.getEntity(1L);
        System.out.println(crClearingEntity);
        SignerInfo signerInfo = signerInfoServiceImpl.getById(5);
        System.out.println(signerInfo);
    }

    @Test
    public void testMulti2(){
        CrClearingEntity crClearingEntity = crClearingService.getOne(1L);
        System.out.println(crClearingEntity);
        SignerInfo signerInfo = signerInfoService.getOne(5L);
        System.out.println(signerInfo);
    }

}
