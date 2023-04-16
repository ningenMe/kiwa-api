package ningenme.net.kiwaapi.application.common.authentication

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import ningenme.net.kiwaapi.application.model.SessionId
import ningenme.net.kiwaapi.infra.redis.UserRedisRepository
import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component

@Component
class CustomAuthenticationSuccessHandler(
    private val userRedisRepository: UserRedisRepository
) : AuthenticationSuccessHandler {
    override fun onAuthenticationSuccess(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authentication: Authentication?
    ) {
        val (sessionId, cookie) = SessionId.of()
        val user: User = authentication?.principal as User

        userRedisRepository.postUserId(sessionId, user.username)

        response?.addCookie(cookie)
        response?.status = HttpStatus.OK.value()
    }

}