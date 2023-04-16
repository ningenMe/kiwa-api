package ningenme.net.kiwaapi.infra.redis

import ningenme.net.kiwaapi.application.model.SessionId
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.ValueOperations
import org.springframework.stereotype.Repository
import java.util.concurrent.TimeUnit

@Repository
class UserRedisRepository(
    @Qualifier(RedisConfig.SESSION_ID_USER_REDIS_TEMPLATE)
    private val redisTemplate: RedisTemplate<String, String>
) {
    fun postUserId(
        sessionId: SessionId,
        userId: String
    ) {
        val valueOperations: ValueOperations<String, String> = redisTemplate.opsForValue()
        valueOperations.set(sessionId.value, userId, 1L, TimeUnit.DAYS)
    }

    fun getUserId(sessionId: SessionId): String {
        val valueOperations: ValueOperations<String, String> = redisTemplate.opsForValue()
        return valueOperations.get(sessionId.value)!!
    }
}