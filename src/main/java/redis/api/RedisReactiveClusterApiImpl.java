package redis.api;

import io.lettuce.core.SetArgs;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.reactive.RedisAdvancedClusterReactiveCommands;
import reactor.core.publisher.Mono;

/**
 * @author <a href="mailto:likelovec@gmail.com">韦朕</a>
 * @date 2022/2/24 13:06
 */
public class RedisReactiveClusterApiImpl implements RedisReactiveApi {

    private final StatefulRedisClusterConnection<String, String> redis;
    private final RedisAdvancedClusterReactiveCommands<String, String> cmd;

    public RedisReactiveClusterApiImpl(StatefulRedisClusterConnection<String, String> connection) {
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