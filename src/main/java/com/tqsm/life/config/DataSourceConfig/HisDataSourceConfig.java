package com.tqsm.life.config.DataSourceConfig;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author xnd
 * @since 2023/11/9 18:37
 */
@Configuration
@MapperScan(value = "com.tqsm.life.mapper.his", sqlSessionFactoryRef = "hisSqlSessionFactory")
@EnableTransactionManagement
public class HisDataSourceConfig {

    @Autowired
    @Qualifier("oracle")
    private MybatisPlusInterceptor mybatisPlusInterceptor;

    @Bean(name = "hisDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.his")
    public DataSource getDateSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "hisSqlSessionFactory")
    public SqlSessionFactory hisSqlSessionFactory(
            @Qualifier("hisDataSource") DataSource datasource) throws Exception {

        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setPlugins(mybatisPlusInterceptor);
        bean.setDataSource(datasource);
        bean.setMapperLocations(// 设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/his/*.xml"));
        return bean.getObject();
    }

    @Bean("hisSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate hisSqlSessionTemplate(
            @Qualifier("hisSqlSessionFactory") SqlSessionFactory sessionFactory) {
        return new SqlSessionTemplate(sessionFactory);
    }

    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("hisDataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
