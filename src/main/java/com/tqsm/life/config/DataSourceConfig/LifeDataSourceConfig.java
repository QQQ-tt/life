package com.tqsm.life.config.DataSourceConfig;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.tqsm.life.config.mybatis.MyMetaObjectHandler;
import org.apache.ibatis.session.ExecutorType;
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
 * @since 2023/11/9 18:32
 */
@Configuration
@MapperScan(value = "com.tqsm.life.mapper.life", sqlSessionFactoryRef = "lifeSqlSessionFactory")
@EnableTransactionManagement
public class LifeDataSourceConfig {

    @Autowired
    private MybatisPlusInterceptor mybatisPlusInterceptor;

    @Autowired
    private MyMetaObjectHandler myMetaObjectHandler;

    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.life")
    public DataSource getDateSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "lifeSqlSessionFactory")
    @Primary
    public SqlSessionFactory sysSqlSessionFactory(
            @Qualifier("dataSource") DataSource datasource) throws Exception {
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
        configuration.setDefaultExecutorType(ExecutorType.BATCH);
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(myMetaObjectHandler);
        bean.setDataSource(datasource);
        bean.setConfiguration(configuration);
        bean.setGlobalConfig(globalConfig);
        bean.setPlugins(mybatisPlusInterceptor);
        bean.setMapperLocations(// 设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/life/*.xml"));
        return bean.getObject();
    }

    @Bean("lifeSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sysSqlSessionTemplate(
            @Qualifier("lifeSqlSessionFactory") SqlSessionFactory sessionFactory) {
        return new SqlSessionTemplate(sessionFactory);
    }

    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


}
