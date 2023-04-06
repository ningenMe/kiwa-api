package ningenme.net.kiwaapi.application.controller

import ningenme.net.kiwaapi.application.generated.controller.HealthcheckApi
import ningenme.net.kiwaapi.application.generated.view.HealthcheckGetResponseView
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthcheckController : HealthcheckApi {

    override fun healthcheckGet(): ResponseEntity<HealthcheckGetResponseView> {
        return ResponseEntity.ok(
            HealthcheckGetResponseView(
                message = "ok"
        ))
    }
}