package ningenme.net.kiwaapi.application.common

import ningenme.net.kiwaapi.infra.UserMysqlRepository
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service


@Service
class CustomAuthenticationUserService(
    private val userMysqlRepository: UserMysqlRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        if (username == null) {
            throw BadCredentialsException("username must not be null")
        }
        val userMysqlDto =
            userMysqlRepository.getUser(username) ?: throw BadCredentialsException("$username is not found")
        return User(userMysqlDto.userId, userMysqlDto.encryptedPassword, listOf())
    }
}