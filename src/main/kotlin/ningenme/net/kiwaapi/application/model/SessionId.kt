package ningenme.net.kiwaapi.application.model

import jakarta.servlet.http.Cookie
import ningenme.net.kiwaapi.application.common.SecurityConfig
import java.time.Duration
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
            cookie.domain = SecurityConfig.DOMAIN
            cookie.maxAge = EXPIRE_DURATION.toSeconds().toInt()
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

        private const val COOKIE_NAME: String = "NINGENME_NET_SESSION"
        val EXPIRE_DURATION: Duration = Duration.ofDays(7L)
    }

}