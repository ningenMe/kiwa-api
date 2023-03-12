package ningenme.net.kiwaapi.application

import ningenme.net.kiwaapi.application.request.UserPostRequestView
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping("/healthcheck")
    fun healthcheckGet(): ResponseEntity<String> {
        return ResponseEntity.ok("ok");
    }


    @PostMapping("/users")
    fun userPost(
        @RequestBody userPostRequestView: UserPostRequestView
    ): ResponseEntity<String> {
        println(userPostRequestView.id)
        println(userPostRequestView.password)
        return ResponseEntity.ok("ok");
    }
}