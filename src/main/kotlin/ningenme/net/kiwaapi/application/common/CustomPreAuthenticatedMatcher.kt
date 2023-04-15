package ningenme.net.kiwaapi.application.common

import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.web.util.matcher.RequestMatcher

class CustomPreAuthenticatedMatcher : RequestMatcher {
    override fun matches(request: HttpServletRequest?): Boolean {
        if (request == null) {
            return true
        }
        if (SecurityConfig.NO_AUTHENTICATED_ENDPOINT.any {
                it.first == request.requestURI
                        && it.second.name() == request.method
            }) {
            return false
        }
        return true
    }

}