package redis.api;

import io.lettuce.core.SetArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.reactive.RedisReactiveCommands;
import reactor.core.publisher.Mono;

/**
 * @author <a href="mailto:likelovec@gmail.com">韦朕</a>
 * @date 2022/2/24 12:29
 */
public class RedisReactiveApiImpl implements RedisReactiveApi {

    private final StatefulRedisConnection<String, String> redis;
    private final RedisReactiveCommands<String, String> cmd;

    public RedisReactiveApiImpl(StatefulRedisConnection<String, String> connection) {
        this.redis = connection;
        this.cmd = redis.reactive();
    }

    @Override
    public Mono<String> set(String key, String val) {
        return this.cmd.set(key, val);
    }

    @Override
    public Mono<String> setex(String key, String val, long amount) {
        return this.cmd.setex(key, amount, val);
    }

    @Override
    public Mono<Boolean> setnx(String key, String val) {
        return this.cmd.setnx(key, val);
    }

    @Override
    public Mono<String> set(String key, String val, SetArgs args) {
        return this.cmd.set(key, val, args);
    }
}