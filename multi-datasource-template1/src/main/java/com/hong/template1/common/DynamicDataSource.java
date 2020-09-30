package com.hong.template1.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    /**
     * 动态路由当前上下文使用哪个数据源
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.getDbType();
    }
}
