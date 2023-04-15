package ningenme.net.kiwaapi.application.model

import jakarta.servlet.http.Cookie
import ningenme.net.kiwaapi.application.common.SecurityConfig
import java.util.*

data class SessionId(
    val value: String
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

        fun of(cookieArray: Array<Cookie>?): SessionId {
            val cookieValue = try {
                cookieArray?.first { it.name.equals(COOKIE_NAME) }
                    ?.value
            } catch (ex: Exception) {
                ""
            }
            return SessionId(cookieValue ?: "")
        }

        const val COOKIE_NAME: String = "NINGENME_NET_SESSION"
    }

}