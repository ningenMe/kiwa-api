package ningenme.net.kiwaapi.application

import ningenme.net.kiwaapi.application.request.UserPostRequestView
import ningenme.net.kiwaapi.infra.UserMysqlRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(
    private val userMysqlRepository: UserMysqlRepository,
    private val passwordEncoder: PasswordEncoder
) {


    @GetMapping("/healthcheck")
    fun healthcheckGet(): ResponseEntity<String> {
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/users")
    fun userPost(
        @RequestBody userPostRequestView: UserPostRequestView
    ): ResponseEntity<String> {
        val userId = userPostRequestView.userId!!;
        val encryptedPassword = passwordEncoder.encode(userPostRequestView.password)
        userMysqlRepository.postUser(userId, encryptedPassword)
        return ResponseEntity.ok("ok");
    }
}