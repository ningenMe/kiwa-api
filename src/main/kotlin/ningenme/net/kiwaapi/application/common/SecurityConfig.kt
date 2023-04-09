package ningenme.net.kiwaapi.application.common

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfig(
    private val customAuthenticationFailureHandler: CustomAuthenticationFailureHandler,
    private val customAuthenticationUserService: CustomAuthenticationUserService,
    private val authenticationConfiguration: AuthenticationConfiguration
) {

    @Bean
    fun securityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        httpSecurity
            .addFilter(customAuthenticationFilter())

            .formLogin()
            .usernameParameter("userId")
            .passwordParameter("password")
            .loginProcessingUrl("/login").permitAll()

            .and()
            .authorizeHttpRequests()
            .requestMatchers(HttpMethod.GET, "/healthcheck").permitAll()
            .requestMatchers(HttpMethod.POST, "/users").permitAll()
            .anyRequest()
            .authenticated()

            .and()
            .cors()
            .configurationSource(corsConfigurationSource())

            .and()
            .csrf()
            .disable()

            .authenticationProvider(daoAuthenticationProvider())


        return httpSecurity.build()
    }

    fun customAuthenticationFilter(): CustomAuthenticationFilter {
        val customAuthenticationFilter = CustomAuthenticationFilter()
        customAuthenticationFilter.setAuthenticationManager(authenticationConfiguration.authenticationManager)
        customAuthenticationFilter.setAuthenticationFailureHandler(customAuthenticationFailureHandler)
        return customAuthenticationFilter
    }

    fun daoAuthenticationProvider(): DaoAuthenticationProvider {
        val daoAuthenticationProvider = DaoAuthenticationProvider()
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder())
        daoAuthenticationProvider.setUserDetailsService(customAuthenticationUserService)
        return daoAuthenticationProvider
    }

    fun corsConfigurationSource(): CorsConfigurationSource {
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.allowedOrigins = listOf("https://ningenme.net")
        corsConfiguration.allowedMethods = listOf("GET", "POST")
        val urlBasedCorsConfigurationSource = UrlBasedCorsConfigurationSource()
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration)
        return urlBasedCorsConfigurationSource
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

}