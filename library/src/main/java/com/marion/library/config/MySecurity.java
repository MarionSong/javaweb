package com.marion.library.config;

import com.marion.library.service.UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
@Configuration
@EnableWebSecurity
public class MySecurity extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService userDetailService(){
        return new UserDetailService();
    }

    /*@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/img/**");
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**","/img/**").permitAll()
                /*.anyRequest().authenticated()*/
                .antMatchers("/rank/**","/").authenticated()
                .and()
                .formLogin().permitAll()
                .usernameParameter("user").passwordParameter("pwd")
                .loginPage("/userlogin");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService())
                .passwordEncoder(new MyPassWordEncoding());

        //这样，页面提交时候，密码以明文的方式进行匹配。
        /*auth.inMemoryAuthentication().passwordEncoder(new MyPassWordEncoding())
                .withUser("user").password("123456").roles("zm");*/
    }


}
