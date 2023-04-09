package ningenme.net.kiwaapi.application.common

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import ningenme.net.kiwaapi.application.generated.view.LoginPostRequestView
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class CustomAuthenticationFilter(
    private val objectMapper: ObjectMapper
) : UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {

        val loginPostRequestView = objectMapper.readValue(request?.inputStream, LoginPostRequestView::class.java)
        val usernamePasswordAuthenticationToken =
            UsernamePasswordAuthenticationToken(loginPostRequestView.userId, loginPostRequestView.password)
        setDetails(request, usernamePasswordAuthenticationToken)
        return authenticationManager.authenticate(usernamePasswordAuthenticationToken)
    }

}