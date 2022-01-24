package org.zerock.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"org.zerock.sample"})
@MapperScan(basePackages= {"org.zerock.mapper"})
public class RootConfig {
	
//	@Bean
//	public DataSource dataSource() {
//		HikariConfig hikariConfig = new HikariConfig();
//		hikariConfig.setDriverClassName("org.mariadb.jdbc.Driver");
//		hikariConfig.setJdbcUrl("jdbc:mariadb://127.0.0.1:3306/yurina");
//		hikariConfig.setUsername("yurina");
//		hikariConfig.setPassword("yurina");
//		
//		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
//		
//		return dataSource; 
//	}
	
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:mysql://localhost:3306/yurina?serverTimezone=Asia/Seoul");
		hikariConfig.setUsername("yurina");
		hikariConfig.setPassword("yurina");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		
		return dataSource; 
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		
		return (SqlSessionFactory) sqlSessionFactory.getObject();
		
	}
 
}
