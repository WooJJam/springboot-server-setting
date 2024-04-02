package woojjam.serversetting.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;
import woojjam.serversetting.entity.TestRedisTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestRedisTemplateService {
    private final RedisTemplate<String, TestRedisTemplate> redisTemplate;
    
    public void save(TestRedisTemplate testRedisTemplate) {
        TestRedisTemplate test = new TestRedisTemplate(testRedisTemplate.getId(), testRedisTemplate.getName(), testRedisTemplate.getAge());
        log.info("test = {}", test);
        SetOperations<String, TestRedisTemplate> setOperations = redisTemplate.opsForSet();
        setOperations.add(test.getId(), test);
    }
}
