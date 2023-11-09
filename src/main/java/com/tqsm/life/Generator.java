package com.tqsm.life;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.tqsm.life.config.BaseEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 *
 * @author qtx
 * @since 2023/8/31 09:03
 */
public class Generator {

    private static final String url;

    private static final String author;

    private static final String password;

    static {
        Map<String, String> getenv = System.getenv();
        author = getenv.get("java_author");
        url = getenv.get("vm_ip");
        password = getenv.get("password");
    }

    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder(
            "jdbc:mysql://" + url + ":3306/life",
            "root",
            password);

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig((scanner, builder) -> builder.author(author)
                        .outputDir(projectPath + "/src/main/java")
                        .disableOpenDir())
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent("com.tqsm")
                        .moduleName("life")
                        .entity("entity")
                        .service("service")
                        .serviceImpl("service.impl")
                        .mapper("mapper.life")
                        .xml("mapper")
                        .controller("controller")
                        .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath +
                                "/src/main/resources/mapper/life")))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply(
                                "请输入表名，多个英文逗号分隔？所有输入 all")))
                        .controllerBuilder()
                        .enableRestStyle()
                        .serviceBuilder()
                        .formatServiceFileName("%sService")
                        .entityBuilder()
                        .disableSerialVersionUID()
                        .enableLombok()
                        .superClass(BaseEntity.class)
                        .enableTableFieldAnnotation()
                        .addSuperEntityColumns("id",
                                "delete_flag",
                                "create_by",
                                "create_on",
                                "update_by",
                                "update_on")
                        .mapperBuilder()
                        .mapperAnnotation(Mapper.class)
                        .build())
                .execute();
    }

    /**
     * 处理 all 情况
     */
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
