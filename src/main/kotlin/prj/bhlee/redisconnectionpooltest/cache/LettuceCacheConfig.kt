package prj.bhlee.redisconnectionpooltest.cache

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class LettuceCacheConfig {

    @Bean
    fun redisTemplate(
        lettuceConnectionFactory: LettuceConnectionFactory,
    ): RedisTemplate<String, String> {
        val template = RedisTemplate<String, String>()
        template.connectionFactory = lettuceConnectionFactory
        template.setDefaultSerializer(StringRedisSerializer())
        template.afterPropertiesSet()

        return template
    }
}
