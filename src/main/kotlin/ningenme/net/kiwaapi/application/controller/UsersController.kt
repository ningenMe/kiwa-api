package ningenme.net.kiwaapi.application.controller

import ningenme.net.kiwaapi.application.generated.controller.UsersApi
import ningenme.net.kiwaapi.application.generated.view.UsersPostRequestView
import ningenme.net.kiwaapi.application.generated.view.UsersPostResponseView
import ningenme.net.kiwaapi.infra.UserMysqlRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersController(
    private val userMysqlRepository: UserMysqlRepository,
    private val passwordEncoder: PasswordEncoder
) : UsersApi {

    override fun usersPost(usersPostRequestView: UsersPostRequestView): ResponseEntity<UsersPostResponseView> {
        val userId = usersPostRequestView.userId;
        val encryptedPassword = passwordEncoder.encode(usersPostRequestView.password)
        userMysqlRepository.postUser(userId, encryptedPassword)
        return ResponseEntity.ok(UsersPostResponseView(message = "ok"));
    }
}