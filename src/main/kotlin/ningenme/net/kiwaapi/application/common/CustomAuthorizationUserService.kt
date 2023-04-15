package ningenme.net.kiwaapi.application.common

import ningenme.net.kiwaapi.application.model.SessionId
import ningenme.net.kiwaapi.infra.mysql.UserMysqlRepository
import ningenme.net.kiwaapi.infra.redis.UserRedisRepository
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken
import org.springframework.stereotype.Service

@Service
class CustomAuthorizationUserService(
    private val userRedisRepository: UserRedisRepository,
    private val userMysqlRepository: UserMysqlRepository
) : AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

    override fun loadUserDetails(token: PreAuthenticatedAuthenticationToken?): UserDetails {
        val sessionId = token?.credentials as SessionId
        val userId = userRedisRepository.getUserId(sessionId)
        val userMysqlDto =
            userMysqlRepository.getUser(userId) ?: throw BadCredentialsException("$userId is not found")
        return User(userMysqlDto.userId, userMysqlDto.encryptedPassword, listOf())
    }

}