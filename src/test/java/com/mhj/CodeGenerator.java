package com.mhj;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * <p>
 * 测试生成代码
 * </p>
 */
public class CodeGenerator {

    @Test
    public void generateCode() {
        String packageName = "com.mhj.kill.service.autogeneration";
        //user -> UserService, 设置成true: user -> IUserService
        boolean serviceNameStartWithI = false;
        generateByTables(serviceNameStartWithI, packageName, "shop_kill");
    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        config.setOutputDir("D:\\mybatis-plus-codeGen");
        config.setActiveRecord(true);
        config.setFileOverride(true);
        config.setBaseResultMap(true);// XML ResultMap
        config.setEnableCache(false);
        config.setBaseColumnList(false);
        config.setAuthor("author");
        config.setMapperName("%sMapper");
        config.setXmlName("%sMapper");
        config.setServiceName("MP%sService");
        config.setServiceImplName("%sServiceImpl");
        config.setControllerName("%sController");// XML columList;
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }

        //数据库配置
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/bay_pay?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "root";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName(driverName);
        dataSourceConfig.setUrl(dbUrl);
        dataSourceConfig.setUsername(userName);
        dataSourceConfig.setPassword(password);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(false);
//        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setDbColumnUnderline(true);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityColumnConstant(true);
        //.setSuperEntityClass("com.rockemb.autogeneration.model.SupperModel")
        //修改替换成你需要的表名，多个表名传数组
        strategyConfig.setInclude(tableNames);

        PackageConfig config1 = new PackageConfig();
        config1.setParent(packageName);
        config1.setMapper("dao");
        config1.setService("service");
        config1.setController("controller");
        config1.setEntity("model");

        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config);
        autoGenerator.setDataSource(dataSourceConfig);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setPackageInfo(config1);
        autoGenerator.execute();
    }

    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }
}
