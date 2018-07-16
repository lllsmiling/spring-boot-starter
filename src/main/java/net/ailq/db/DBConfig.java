package net.ailq.db;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务连接mysql配置文件
 *
 * @author lllsmiling
 * @create 2017-10-23 14:20
 **/
@Configuration
@ConfigurationProperties("db.datasource")
@MapperScan(basePackages = "net.ailq.dao", sqlSessionFactoryRef = DBConfig.SQL_SESSION_FACTORY_NAME)
public class DBConfig {
    static final String SQL_SESSION_FACTORY_NAME = "dbSessionFactory";
    static final String xmlPath = "classpath:/mapper/*.xml";

    @Autowired
    WallFilter wallFilter;


    @NotNull
    @Value("db.datasource.username")
    private String username;

    @NotNull
    @Value("db.datasource.password")
    private String password;

    @NotNull
    @Value("db.datasource.url")
    private String url;
    @Value("${db.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.initial-size}")
    private int initialSize;

    @Value("${spring.datasource.min-idle}")
    private int minIdle;

    @Value("${spring.datasource.max-idle}")
    private int maxActive;

    @Value("${spring.datasource.max-wait}")
    private int maxWait;

    @Value("${spring.datasource.validation-query}")
    private String validationQuery;

    @Value("${spring.datasource.test-while-idle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.test-on-borrow}")
    private boolean testOnBorrow;
    @Value("${spring.datasource.time-between-eviction-runs-millis}")
    private int timeBetweenEvictionRunsMillis;

    @Bean(name = "userDatasource")
    //@Primary  //多数据选必须设置主数据源
    public DataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        List<Filter> filterList=new ArrayList<>();
        filterList.add(wallFilter);
        datasource.setProxyFilters(filterList);

        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);

        /**
         * 设置连接数据库采用utf8mb4，如果不用可删除
         */
        ArrayList<String> list = new ArrayList<>();
        list.add("set names utf8mb4");
        datasource.setConnectionInitSqls(list);

        return datasource;
    }

    @Bean
    public WallFilter wallFilter(){
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig());
        return wallFilter;
    }

    @Bean
    public WallConfig wallConfig(){
        WallConfig wallConfig = new WallConfig();
        wallConfig.setMultiStatementAllow(true);//允许一次执行多条语句
        wallConfig.setNoneBaseStatementAllow(true);//允许一次执行多条语句
        return wallConfig;
    }
    @Bean(name = DBConfig.SQL_SESSION_FACTORY_NAME)
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration ibatisConfiguration = new org.apache.ibatis.session.Configuration();
        ibatisConfiguration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(ibatisConfiguration);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(xmlPath));
        sqlSessionFactoryBean.setDataSource(dataSource());
        return sqlSessionFactoryBean.getObject();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
