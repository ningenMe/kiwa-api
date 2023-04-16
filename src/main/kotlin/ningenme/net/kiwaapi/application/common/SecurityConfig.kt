package ningenme.net.kiwaapi.application.common

import com.fasterxml.jackson.databind.ObjectMapper
import ningenme.net.kiwaapi.application.common.authentication.CustomAuthenticationFailureHandler
import ningenme.net.kiwaapi.application.common.authentication.CustomAuthenticationFilter
import ningenme.net.kiwaapi.application.common.authentication.CustomAuthenticationSuccessHandler
import ningenme.net.kiwaapi.application.common.authentication.CustomAuthenticationUserService
import ningenme.net.kiwaapi.application.common.authorization.CustomAuthenticationEntryPoint
import ningenme.net.kiwaapi.application.common.authorization.CustomAuthorizationUserService
import ningenme.net.kiwaapi.application.common.authorization.CustomPreAuthenticatedMatcher
import ningenme.net.kiwaapi.application.common.authorization.CustomPreAuthenticatedProcessingFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfig(
    private val customAuthenticationFailureHandler: CustomAuthenticationFailureHandler,
    private val customAuthenticationSuccessHandler: CustomAuthenticationSuccessHandler,
    private val customAuthenticationUserService: CustomAuthenticationUserService,
    private val customAuthorizationUserService: CustomAuthorizationUserService,
    private val customAuthenticationEntryPoint: CustomAuthenticationEntryPoint,
    private val objectMapper: ObjectMapper
) {

    companion object {
        const val DOMAIN = "ningenme.net"
        const val PATH_LOGIN = "/login"
        const val PATH_HEALTHCHECK = "/healthcheck"
        const val PATH_USERS = "/users"
        val NO_AUTHENTICATED_ENDPOINT = listOf(
            PATH_HEALTHCHECK to HttpMethod.GET,
            PATH_LOGIN to HttpMethod.POST,
            PATH_USERS to HttpMethod.POST
        )
    }

    @Bean
    fun securityFilterChain(
        httpSecurity: HttpSecurity,
        authenticationManager: AuthenticationManager,
        customAuthenticationFilter: CustomAuthenticationFilter,
        customPreAuthenticatedProcessingFilter: CustomPreAuthenticatedProcessingFilter
    ): SecurityFilterChain {
        httpSecurity
            .addFilter(customAuthenticationFilter)
            .addFilter(customPreAuthenticatedProcessingFilter)

            .formLogin()
            .usernameParameter("userId")
            .passwordParameter("password")
            .loginProcessingUrl(PATH_LOGIN).permitAll()

            .and()
            .authorizeHttpRequests()
            .requestMatchers(HttpMethod.GET, PATH_HEALTHCHECK).permitAll()
            .requestMatchers(HttpMethod.POST, PATH_USERS).permitAll()
            .anyRequest()
            .authenticated()

            .and()
            .authenticationManager(authenticationManager)
            .exceptionHandling()
            .authenticationEntryPoint(customAuthenticationEntryPoint)
            .and()

            .cors()
            .configurationSource(corsConfigurationSource())

            .and()
            .csrf()
            .disable()

        return httpSecurity.build()
    }

    @Bean
    fun customAuthenticationFilter(
        authenticationManager: AuthenticationManager
    ): CustomAuthenticationFilter {
        val customAuthenticationFilter = CustomAuthenticationFilter(objectMapper)
        customAuthenticationFilter.setAuthenticationManager(authenticationManager)
        customAuthenticationFilter.setAuthenticationFailureHandler(customAuthenticationFailureHandler)
        customAuthenticationFilter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler)
        return customAuthenticationFilter
    }

    @Bean
    fun customPreAuthenticatedProcessingFilter(
        authenticationManager: AuthenticationManager
    ): CustomPreAuthenticatedProcessingFilter {
        val customPreAuthenticatedProcessingFilter = CustomPreAuthenticatedProcessingFilter()
        customPreAuthenticatedProcessingFilter.setAuthenticationManager(authenticationManager)
        customPreAuthenticatedProcessingFilter.setRequiresAuthenticationRequestMatcher(CustomPreAuthenticatedMatcher())
        return customPreAuthenticatedProcessingFilter
    }


    fun corsConfigurationSource(): CorsConfigurationSource {
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.allowedOrigins = listOf("https://$DOMAIN", "http://localhost:3000")
        corsConfiguration.allowedMethods = listOf(HttpMethod.GET.name(), HttpMethod.POST.name())
        val urlBasedCorsConfigurationSource = UrlBasedCorsConfigurationSource()
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration)
        return urlBasedCorsConfigurationSource
    }

    @Bean
    fun authenticationManager(httpSecurity: HttpSecurity): AuthenticationManager {
        val authenticationManagerBuilder =
            httpSecurity.sharedObjects[AuthenticationManagerBuilder::class.java] as AuthenticationManagerBuilder
        authenticationManagerBuilder
            .authenticationProvider(preAuthenticatedAuthenticationProvider())
            .authenticationProvider(daoAuthenticationProvider())
        return authenticationManagerBuilder.build()
    }

    fun preAuthenticatedAuthenticationProvider(): PreAuthenticatedAuthenticationProvider {
        val preAuthenticatedAuthenticationProvider = PreAuthenticatedAuthenticationProvider()
        preAuthenticatedAuthenticationProvider.setPreAuthenticatedUserDetailsService(customAuthorizationUserService)
        return preAuthenticatedAuthenticationProvider
    }


    fun daoAuthenticationProvider(): DaoAuthenticationProvider {
        val daoAuthenticationProvider = DaoAuthenticationProvider()
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder())
        daoAuthenticationProvider.setUserDetailsService(customAuthenticationUserService)
        return daoAuthenticationProvider
    }


    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()


}