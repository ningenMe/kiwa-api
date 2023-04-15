package ningenme.net.kiwaapi.application.common

import jakarta.servlet.http.HttpServletRequest
import ningenme.net.kiwaapi.application.model.SessionId
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter

class CustomPreAuthenticatedProcessingFilter : AbstractPreAuthenticatedProcessingFilter() {
    override fun getPreAuthenticatedPrincipal(request: HttpServletRequest?): Any {
        return ""
    }

    override fun getPreAuthenticatedCredentials(request: HttpServletRequest?): Any {
        return SessionId.of(request?.cookies)
    }
}