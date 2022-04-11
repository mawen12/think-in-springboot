package com.mawen.demo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {MySQLDataSource2Config.PACKAGE2}, sqlSessionFactoryRef = "mysqlSqlSessionFactory2")
public class MySQLDataSource2Config {

    public static final String PACKAGE2 = "com.mawen.demo.dao.mysql2";
    public static final String MAPPER_LOCATION2 = "classpath:/mapper/mysql2/*.xml";

    @Bean("mysqlDataSource2")
    @ConfigurationProperties("spring.datasource.druid.mysql2")
    public DataSource mysqlDataSource2() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("mysqlTransactionManager2")
    public DataSourceTransactionManager mysqlTransactionManager2() {
        return new DataSourceTransactionManager(mysqlDataSource2());
    }

    @Bean("mysqlSqlSessionFactory2")
    public SqlSessionFactory mysqlSessionFactory2(@Qualifier("mysqlDataSource2") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION2));
        return sqlSessionFactoryBean.getObject();
    }

}
