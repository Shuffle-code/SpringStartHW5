//package org.example.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.datasource.SimpleDriverDataSource;
//
//import javax.sql.DataSource;
//import java.sql.Driver;
//
//@Configuration
//@PropertySource("classpath:jdbc.properties")
//@ComponentScan("org.example")
//public class DbConfig {
//
//    @Value("${driverClassName}")
//    private String driverClassName;
//    @Value("${url}")
//    private String url;
//    @Value("${usernameDb}")
//    private String usernameDb;
//    @Value("${password}")
//    private String password;
//
//
////    @Value("${driverClassName}")
////    private String driverClassName;
////    @Value("${url}")
////    private String url;
////    @Value("${username}")
////    private String username;
////    @Value("${password}")
////    private String password;
//
//    @Bean
//    public DataSource dataSource() {
//        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
//        try {
//            Class<? extends Driver> driver = (Class<? extends Driver>) Class.forName(driverClassName);
//            dataSource.setDriverClass(driver);
//            dataSource.setUrl(url);
//            dataSource.setUsername(usernameDb);
//            dataSource.setPassword(password);
//            return dataSource;
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource(dataSource());
//        return jdbcTemplate;
//    }
//
//    @Bean
//    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
//        return new NamedParameterJdbcTemplate(dataSource());
//    }
//
//}
