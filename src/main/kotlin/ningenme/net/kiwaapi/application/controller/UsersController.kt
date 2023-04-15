package ningenme.net.kiwaapi.application.controller

import ningenme.net.kiwaapi.application.generated.controller.UsersApi
import ningenme.net.kiwaapi.application.generated.view.UsersGetResponseAuthorityView
import ningenme.net.kiwaapi.application.generated.view.UsersGetResponseView
import ningenme.net.kiwaapi.application.generated.view.UsersPostRequestView
import ningenme.net.kiwaapi.application.generated.view.UsersPostResponseView
import ningenme.net.kiwaapi.infra.mysql.UserMysqlRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersController(
    private val userMysqlRepository: UserMysqlRepository,
    private val passwordEncoder: PasswordEncoder
) : UsersApi {
    override fun usersGet(): ResponseEntity<UsersGetResponseView> {
        val user = SecurityContextHolder.getContext().authentication.principal as User
        return ResponseEntity.ok(
            UsersGetResponseView(
                isLoggedIn = true,
                userId = user.username,
                authority = UsersGetResponseAuthorityView(
                    comproCategory = false
                )
            )
        )
    }

    override fun usersPost(usersPostRequestView: UsersPostRequestView): ResponseEntity<UsersPostResponseView> {
        val userId = usersPostRequestView.userId;
        val encryptedPassword = passwordEncoder.encode(usersPostRequestView.password)
        userMysqlRepository.postUser(userId, encryptedPassword)
        return ResponseEntity.ok(UsersPostResponseView(message = "ok"));
    }
}