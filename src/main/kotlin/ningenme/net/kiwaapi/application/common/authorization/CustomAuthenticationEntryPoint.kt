package ningenme.net.kiwaapi.application.common.authorization

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import ningenme.net.kiwaapi.application.generated.view.UnAuthenticated401View
import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component

@Component
class CustomAuthenticationEntryPoint(
    private val objectMapper: ObjectMapper
) : AuthenticationEntryPoint {

    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authException: AuthenticationException?
    ) {
        response?.status = HttpStatus.UNAUTHORIZED.value()
        objectMapper.writeValue(
            response?.outputStream, UnAuthenticated401View(
                message = "UnAuthenticated"
            )
        )
    }
}