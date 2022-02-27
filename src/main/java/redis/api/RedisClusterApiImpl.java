package redis.api;

import io.lettuce.core.SetArgs;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;

/**
 * @author <a href="mailto:likelovec@gmail.com">韦朕</a>
 * @date 2022/2/24 12:14
 */
public class RedisClusterApiImpl implements RedisApi {

    private final StatefulRedisClusterConnection<String, String> redis;
    private final RedisAdvancedClusterCommands<String, String> cmd;

    public  RedisClusterApiImpl(StatefulRedisClusterConnection<String, String> connection) {
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