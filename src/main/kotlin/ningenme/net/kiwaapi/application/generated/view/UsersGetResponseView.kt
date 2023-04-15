package ningenme.net.kiwaapi.application.generated.view

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import ningenme.net.kiwaapi.application.generated.view.UsersGetResponseAuthorityView
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import jakarta.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param isLoggedIn 
 * @param userId 
 * @param authority 
 */
data class UsersGetResponseView(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("isLoggedIn", required = true) val isLoggedIn: kotlin.Boolean,

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("userId", required = true) val userId: kotlin.String,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("authority", required = true) val authority: UsersGetResponseAuthorityView
) {

}

