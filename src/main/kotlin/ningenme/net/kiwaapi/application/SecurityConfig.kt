package ningenme.net.kiwaapi.application

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        httpSecurity
            .formLogin()
            .loginProcessingUrl("/login").permitAll()

            .and()
            .authorizeHttpRequests()
            .requestMatchers(HttpMethod.GET, "/healthcheck").permitAll()
            .requestMatchers(HttpMethod.POST, "/users").permitAll()
            .anyRequest()
            .authenticated()

            .and()
            .csrf()
            .disable()

        return httpSecurity.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

}