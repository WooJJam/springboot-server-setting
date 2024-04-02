package woojjam.serversetting.config;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import woojjam.serversetting.entity.TestRedisTemplate;

import java.time.format.DateTimeFormatter;

@Slf4j
@Configuration
@EnableRedisRepositories
@RequiredArgsConstructor
public class RedisConfig {

    @Value("${spring.data.redis.host}")
    private String host;

    @Value("${spring.data.redis.port}")
    private int port;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        log.info("host = {}",host);
        log.info("port = {}", port);
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate <?, ?> testRedisTemplate() {
        RedisTemplate<String, TestRedisTemplate> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());

        // 기본 직렬화( JSON 형식) Object <=> JSON
        redisTemplate.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());

        // Key 직렬화 (String 형식)
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        // value 직렬화 (JSON 형식)
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        // 해시 데이터 구조 직렬화 (JSON 형식)
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        return redisTemplate;
    }
}
