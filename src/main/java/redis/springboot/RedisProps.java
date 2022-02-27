package redis.springboot;

import io.lettuce.core.RedisURI;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author <a href="mailto:likelovec@gmail.com">韦朕</a>
 * @date 2022/2/24 14:11
 */
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisProps {

    /**
     * redis 单机模式
     */
    private StandAlone standAlone;

    @Data
    public static class StandAlone {

        /**
         * 主机
         */
        private String host;
        /**
         * redis开放的端口
         */
        private int port;

        /**
         * redis 密码
         */
        private String passwd;

        public RedisURI toRedisUri() {
            final var redisURI = RedisURI.create(host, port);
            if (passwd != null && !passwd.isBlank()) {
                redisURI.setPassword(passwd);
            }

            return redisURI;
        }
    }
}