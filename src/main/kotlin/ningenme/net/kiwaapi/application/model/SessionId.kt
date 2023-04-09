package ningenme.net.kiwaapi.application.model

import jakarta.servlet.http.Cookie
import ningenme.net.kiwaapi.application.common.SecurityConfig
import java.util.*

data class SessionId(
    private val value: String
) {
    companion object {
        fun of(): Pair<SessionId, Cookie> {
            val sessionId = SessionId(UUID.randomUUID().toString())
            val cookie = Cookie(COOKIE_NAME, sessionId.value)
            cookie.isHttpOnly = true
            cookie.secure = true
            cookie.domain = SecurityConfig.DOMAIN;
            return sessionId to cookie
        }

        const val COOKIE_NAME: String = "NINGENME_NET_SESSION"
    }

}