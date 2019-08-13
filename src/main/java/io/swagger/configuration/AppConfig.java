package io.swagger.configuration;

import io.swagger.model.MineUserConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.convert.RedisCustomConversions;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.util.Arrays;
import java.util.UUID;

@Configuration
@EnableRedisRepositories
public class AppConfig {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        String redisHost = System.getenv().getOrDefault("REDIS_HOST_ENV", "192.168.99.100");
        String redisPort = System.getenv().getOrDefault("REDIS_PORT_ENV", "6379");
        System.out.println("Redis @ "+ redisHost + ":" + redisPort);
        return new LettuceConnectionFactory(redisHost, Integer.valueOf(redisPort));  
    }

    @Bean(name="redisTemplate")
    public RedisTemplate<UUID, MineUserConfig> getRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        final RedisTemplate<UUID, MineUserConfig> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer(MineUserConfig.class));
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(MineUserConfig.class));
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public RedisCustomConversions redisCustomConversions() {
        return new RedisCustomConversions(
                Arrays.asList(new UUIDToStringConverter(), new BytesToUUIDConverter()));
    }
}
