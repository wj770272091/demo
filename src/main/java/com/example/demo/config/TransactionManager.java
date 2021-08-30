//package com.example.demo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
///**
// * @NAME: TransactionManager
// * @USER: 77027
// * @DATE: 2020/12/28
// * @TIME: 11:06
// */
//@Configuration
//public class TransactionManager {
//    @Resource
//    DataSource dataSource;
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setDataSource(dataSource);
//        return transactionManager;
//    }
//
////    @Bean
////    @ConditionalOnMissingBean
////    @ConditionalOnBean(DataSource.class)
////    public PlatformTransactionManager transactionManager(){
////        return new DataSourceTransactionManager(this.dataSource);
////    }
//}
