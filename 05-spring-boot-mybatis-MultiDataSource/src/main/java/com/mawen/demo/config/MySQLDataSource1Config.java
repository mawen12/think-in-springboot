package com.mawen.demo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

import static com.mawen.demo.config.MySQLDataSource1Config.PACKAGE1;

@Configuration
@MapperScan(basePackages = {PACKAGE1}, sqlSessionFactoryRef = "mysqlSqlSessionFactory1")
public class MySQLDataSource1Config {
    //==========================================mysql1======================================
    public static final String PACKAGE1 = "com.mawen.demo.dao.mysql1";
    public static final String MAPPER_LOCATION1 = "classpath:/mapper/mysql1/*.xml";

    @Primary
    @Bean("mysqlDataSource1")
    @ConfigurationProperties("spring.datasource.druid.mysql1")
    public DataSource mysqlDataSource1() {
        return DruidDataSourceBuilder.create().build();
    }

    @Primary
    @Bean("mysqlTransactionManager1")
    public DataSourceTransactionManager mysqlTransactionManager1() {
        return new DataSourceTransactionManager(mysqlDataSource1());
    }

    @Primary
    @Bean("mysqlSqlSessionFactory1")
    public SqlSessionFactory mysqlSessionFactory1(@Qualifier("mysqlDataSource1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION1));
        return sqlSessionFactoryBean.getObject();
    }
}
