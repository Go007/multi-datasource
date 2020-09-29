package com.hong.aop;

import com.hong.common.DBTypeEnum;
import com.hong.common.DataSourceSwitch;
import com.hong.common.DbContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 数据源动态切换AOP
 */
@Component
@Aspect
@Order(-100) //为了保证数据源切换before-happen事务,且数字越小,前置方法越先执行,后置方法越后执行
@Slf4j
public class DataSourceSwitchAspect {

    @Pointcut("execution(public * com.hong.service.db1..*.*(..))")
    private void db1Aspect() {
    }

    @Pointcut("execution(public * com.hong.service.db2..*.*(..))")
    //@Pointcut("@annotation(DataSourceSwitch)")
    private void db2Aspect() {
    }

    @Before("db1Aspect()")
    public void determineDb1(JoinPoint joinPoint) {
        log.info("切换到db1 数据源...");
        setDataSource(joinPoint, DBTypeEnum.db1);
    }

    @Before("db2Aspect()")
    public void determineDb2(JoinPoint joinPoint) {
        log.info("切换到db2 数据源...");
        setDataSource(joinPoint, DBTypeEnum.db2);
    }

    @After("db1Aspect()")
    public void clearDb1() {
        log.info("清除db1 数据源...");
        DbContextHolder.clearDbType();
    }

    @After("db2Aspect()")
    public void clearDb2() {
        log.info("清除db2 数据源...");
        DbContextHolder.clearDbType();
    }

    /**
     * 添加注解方式,如果有注解优先注解,没有则按传过来的数据源配置
     *
     * @param joinPoint
     * @param dbTypeEnum
     */
    private void setDataSource(JoinPoint joinPoint, DBTypeEnum dbTypeEnum) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        DataSourceSwitch dataSourceSwitch = methodSignature.getMethod().getAnnotation(DataSourceSwitch.class);
        if (Objects.isNull(dataSourceSwitch) || Objects.isNull(dataSourceSwitch.value())) {
            DbContextHolder.setDbType(dbTypeEnum);
        } else {
            log.info("根据注解来切换数据源,注解值为:" + dataSourceSwitch.value());
            switch (dataSourceSwitch.value().getValue()) {
                case "db1":
                    DbContextHolder.setDbType(DBTypeEnum.db1);
                    break;
                case "db2":
                    DbContextHolder.setDbType(DBTypeEnum.db2);
                    break;
                default:
                    DbContextHolder.setDbType(dbTypeEnum);
            }
        }
    }
}
