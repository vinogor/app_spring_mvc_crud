package crud.app.config;

import crud.app.service.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"crud.app.service", "crud.app.dao"}) // где поискать бины для создания
public class SpringConfig {

    @Bean // по дефолту это Синглетон
    public TestBean getTestBean() {
        return new TestBean("Hello!");
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(
            "jdbc:mysql://localhost:3306/schema_coffee?serverTimezone=UTC"); // &useSll=false
        dataSource.setUsername("root");
        dataSource.setPassword("123123");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

//    @Bean
//    public UserDao getUserDao() {
//        return new UserDaoImpl();
//    }

//    @Bean
//    public UserService getUserService() {
//        return new UserServiceImpl();
//    }
}
