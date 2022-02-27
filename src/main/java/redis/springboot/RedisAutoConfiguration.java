package redis.springboot;

import io.lettuce.core.RedisClient;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.api.RedisApi;
import redis.api.RedisApiImpl;
import redis.api.RedisReactiveApi;
import redis.api.RedisReactiveApiImpl;

/**
 * @author <a href="mailto:likelovec@gmail.com">韦朕</a>
 * @date 2022/2/24 14:04
 */
@Configuration
@EnableConfigurationProperties(RedisProps.class)
public class RedisAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "redis", name = "stand-alone.host")
    RedisClient redisClient(RedisProps redisProps) {
        return RedisClient.create(redisProps.getStandAlone().toRedisUri());
    }

    @SneakyThrows
    @Bean
    @ConditionalOnBean(RedisClient.class)
    RedisApi redisApi(@Autowired RedisClient redisClient) {
        return new RedisApiImpl(redisClient.connect());
    }

    @SneakyThrows
    @Bean
    @ConditionalOnBean(RedisClient.class)
    RedisReactiveApi redisReactiveApi(@Autowired RedisClient redisClient) {
        return new RedisReactiveApiImpl(redisClient.connect());
    }
}