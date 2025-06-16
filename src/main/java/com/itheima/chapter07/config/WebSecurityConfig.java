package com.itheima.chapter07.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig  {
/*    @Autowired
    private DataSource dataSource;*/
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
    @Bean
    public  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests() // 定义哪些URL需要被保护、哪些不需要被保护
                .mvcMatchers("/loginview","/css/**","/img/**").permitAll()// 设置所有人都可以访问登录页面
                .mvcMatchers("/index", "/publishers").permitAll()
                //.mvcMatchers("/book/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated()  // 任何请求,登录后可以访问
                .and()
                .formLogin()
                    .loginPage("/loginview")
                    .loginProcessingUrl("/doLogin")
                    .and().logout()
                .and()
                .csrf().disable()//禁止csrf 跨站请求保护;
                .headers().frameOptions().sameOrigin();
        return http.build();
    }

/*    @Bean
    public UserDetailsService userDetailsService() {
        String userSQL ="SELECT username,password, valid " +
                "FROM user WHERE username = ?";
        String authoritySQL="SELECT u.username,p.authority " +
                "FROM user u,priv p,user_priv up " +
                "WHERE up.user_id=u.id AND up.priv_id=p.id and u.username =?";
        JdbcUserDetailsManager users = new JdbcUserDetailsManager();
        users.setDataSource(dataSource);
        users.setUsersByUsernameQuery(userSQL);
        users.setAuthoritiesByUsernameQuery(authoritySQL);
        return users;
    }*/
/*    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();
        users.createUser(User.withUsername("zhangsan")
                .password("{noop}1234")
                .roles("admin")
                //.authorities("ROLE_admin")
                .build());
        return users;
    }*/
}
