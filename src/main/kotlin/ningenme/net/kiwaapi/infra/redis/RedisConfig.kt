package ningenme.net.kiwaapi.infra.redis

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class RedisConfig {
    companion object {
        const val SESSION_ID_USER_REDIS_TEMPLATE = "SessionIdUserRedisTemplate"
    }

    @Bean(SESSION_ID_USER_REDIS_TEMPLATE)
    fun sessionIdUserRedisTemplate(
        redisConnectionFactory: RedisConnectionFactory?
    ): RedisTemplate<String, String> {
        val redisTemplate: RedisTemplate<String, String> = RedisTemplate()
        redisTemplate.setConnectionFactory(redisConnectionFactory!!)
        redisTemplate.keySerializer = StringRedisSerializer()
        redisTemplate.valueSerializer = Jackson2JsonRedisSerializer(String::class.java)
        return redisTemplate
    }
}