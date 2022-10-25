import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunnoc
 * @date 2020-03-14 21:56
 */
public class SunNocAutoGenerator {


    public static void main(String[] args) {
        //项目路径
       /* String projectPath = System.getProperty("user.dir");
        String outPutDir = projectPath + "/src/main/java";
        String author = "";
        //模块名
        String moduleName = "inform";
        //不生成表前缀
        String tablePrefix = "middle_";
        //自动生成的表，多个表用逗号分隔
        String includeTableName = "middle_inform";
        //数据库连接信息
        *//*String dataName = "majunhong";
        String dataPwd = "Ddysx2!#!o6cuUKB";
        String dataUrl = "jdbc:mysql://rm-wz9iczio21e8edu15rw.mysql.rds.aliyuncs.com:3306/ds_data_test?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2b8";
        *//*
        String dataName = "school_sys";
        String dataPwd = "kRPTyj2wMriK5sxa";
        String dataUrl = "jdbc:mysql://101.43.247.252:3306/school_sys?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2b8&zeroDateTimeBehavior=CONVERT_TO_NULL";
        String driverName = "com.mysql.cj.jdbc.Driver";
        //包名
        String parentPackage = "middle.school";
        //设置主键策略
        IdType idType = IdType.AUTO;
        DbType dbType = DbType.MYSQL;

        //1. 创建代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //2. 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outPutDir);
        gc.setAuthor(author);
        //生成后是否打开资源管理器
        gc.setOpen(false);
        //重新生成文件的时候是否会覆盖
        gc.setFileOverride(false);
        //主键策略
        gc.setIdType(idType);
        //所有自动生成的Service接口首字母I去除
        gc.setServiceName("%sService");
        //设置日期类型
        gc.setDateType(DateType.ONLY_DATE);
        // 实体属性 Swagger2 注解
        //gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);
        //3. 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dataUrl);
        // dsc.setSchemaName("public");
        dsc.setDriverName(driverName);
        dsc.setUsername(dataName);
        dsc.setPassword(dataPwd);
        dsc.setDbType(dbType);
        mpg.setDataSource(dsc);

        //4. 生成的包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setParent(parentPackage);
        pc.setEntity("entity");
        pc.setController("controller");
        pc.setMapper("mapper");
        pc.setService("service");
        mpg.setPackageInfo(pc);


        // 5.自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" + moduleName
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));


        // 6. 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 映射的表明
        strategy.setInclude(includeTableName.split(","));

        //数据映射到实体类的策略
        strategy.setNaming(NamingStrategy.underline_to_camel);

        //不生成表的前缀
        strategy.setTablePrefix(tablePrefix);

        // 自动添加lombok的注解
        strategy.setEntityLombokModel(true);

        // 逻辑删除，逻辑删除字段名
        //strategy.setLogicDeleteFieldName("is_deleted");

        //去除布尔值的 is_ 前缀
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);

        // 自动填充
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);

        //乐观锁的列
        //strategy.setVersionFieldName("version");

        // RestFUL
        strategy.setRestControllerStyle(true);

        // url驼峰命名 转化为 _
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);
        //7.执行
        mpg.execute();*/
    }

}