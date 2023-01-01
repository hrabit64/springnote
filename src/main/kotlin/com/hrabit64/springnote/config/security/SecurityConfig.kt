package com.hrabit64.springnote.config.security


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig(@Autowired val customOAuth2UserService:CustomOAuth2UserService){

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        http
            .authorizeHttpRequests()
                .requestMatchers("/","/css/**","/images/**","/js/**","/error","/registration","/posts/**","/categories/**").permitAll()
                .requestMatchers("/api/v1/**","/post/**").hasRole("OWNER")
                .anyRequest().authenticated()
            .and()
                .logout()
                .logoutSuccessUrl("/")
            .and()
                .oauth2Login()
                .defaultSuccessUrl("/")
                .userInfoEndpoint()
                .userService(customOAuth2UserService)

        return http.build()
    }

}