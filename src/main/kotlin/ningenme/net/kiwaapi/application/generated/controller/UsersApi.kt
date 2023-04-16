/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
*/
package ningenme.net.kiwaapi.application.generated.controller

import ningenme.net.kiwaapi.application.generated.view.UnAuthenticated401View
import ningenme.net.kiwaapi.application.generated.view.UsersMeGetResponseView
import ningenme.net.kiwaapi.application.generated.view.UsersPostRequestView
import ningenme.net.kiwaapi.application.generated.view.UsersPostResponseView
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.validation.annotation.Validated
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.beans.factory.annotation.Autowired

import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import jakarta.validation.Valid

import kotlin.collections.List
import kotlin.collections.Map

@Validated
@RequestMapping("\${api.base-path:}")
interface UsersApi {

    @Operation(
        summary = "",
        operationId = "usersGet",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "ok", content = [Content(schema = Schema(implementation = UsersMeGetResponseView::class))]),
            ApiResponse(responseCode = "401", description = "unauthenticated 401", content = [Content(schema = Schema(implementation = UnAuthenticated401View::class))])
        ]
    )
    @RequestMapping(
            method = [RequestMethod.GET],
            value = ["/users/me"],
            produces = ["application/json"]
    )
    fun usersGet(): ResponseEntity<UsersMeGetResponseView>

    @Operation(
        summary = "",
        operationId = "usersPost",
        description = """""",
        responses = [
            ApiResponse(responseCode = "200", description = "ok", content = [Content(schema = Schema(implementation = UsersPostResponseView::class))])
        ]
    )
    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["/users"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun usersPost(@Parameter(description = "", required = true) @Valid @RequestBody usersPostRequestView: UsersPostRequestView): ResponseEntity<UsersPostResponseView>
}
