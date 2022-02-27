package redis.api;

import io.lettuce.core.SetArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

/**
 * @author <a href="mailto:likelovec@gmail.com">韦朕</a>
 * @date 2022/2/24 12:13
 */
public class RedisApiImpl implements RedisApi {

    private final StatefulRedisConnection<String, String> redis;
    private final RedisCommands<String, String> cmd;

    public RedisApiImpl(StatefulRedisConnection<String, String> connection) {
        this.redis = connection;
        this.cmd = redis.sync();
    }

    @Override
    public String set(String key, String val) {
        return this.cmd.set(key, val);
    }

    @Override
    public String setex(String key, String val, long amount) {
        return this.cmd.setex(key, amount, val);
    }

    @Override
    public Boolean setnx(String key, String val) {
        return this.cmd.setnx(key, val);
    }

    @Override
    public String set(String key, String val, SetArgs args) {
        return this.cmd.set(key, val, args);
    }
}