package redis.api;

import io.lettuce.core.SetArgs;
import reactor.core.publisher.Mono;

/**
 * redis reactive(with reactor) api
 *
 * @author <a href="mailto:likelovec@gmail.com">韦朕</a>
 * @date 2022/2/24 12:29
 */
public interface RedisReactiveApi {

    /**
     * Set the string value of a key.
     *
     * @param key   the key.
     * @param value the value.
     * @return String simple-string-reply {@code OK} if {@code SET} was executed correctly.
     */
    Mono<String> set(String key, String value);

    /**
     * Set the value and expiration of a key.
     *
     * @param key    the key.
     * @param value  the value.
     * @param amount the seconds type: long.
     * @return String simple-string-reply.
     */
    Mono<String> setex(String key, String value, long amount);

    /**
     * Set the value of a key, only if the key does not exist.
     *
     * @param key   the key.
     * @param value the value.
     * @return Boolean integer-reply specifically:
     * <p>
     * {@code 1} if the key was set {@code 0} if the key was not set.
     */
    Mono<Boolean> setnx(String key, String value);

    /**
     * Set the string value of a key.
     *
     * @param key   the key.
     * @param value the value.
     * @param args  the setArgs.
     * @return String simple-string-reply {@code OK} if {@code SET} was executed correctly.
     */
    Mono<String> set(String key, String value, SetArgs args);
}