package com.hong.template2.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Description:
 * @Author wanghong
 * @Date 2020/9/30 13:32
 * @Version V1.0
 **/
@Configuration
@MapperScan(basePackages = "com.hong.template2.mapper.db2", sqlSessionTemplateRef = "db2SqlSessionTemplate")
public class Db2DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.db2")
    public DataSource db2DataSource() {
        return new DruidDataSource();
    }

    @Bean
    public SqlSessionFactory db2SqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(db2DataSource());
        bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/db2/*.xml"));
        return bean.getObject();
    }

    @Bean
    public DataSourceTransactionManager db2TransactionManager() {
        return new DataSourceTransactionManager(db2DataSource());
    }

    @Bean
    public SqlSessionTemplate db2SqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(db2SqlSessionFactory());
    }
}
