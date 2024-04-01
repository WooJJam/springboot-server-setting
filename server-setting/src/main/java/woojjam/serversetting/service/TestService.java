package woojjam.serversetting.service;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.PartialUpdate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import woojjam.serversetting.RedisRepository.TestRedisRepository;
import woojjam.serversetting.entity.TestRedis;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {

    @Resource(name = "redisTemplate")
    private final ValueOperations<String, String> aa;
    private final TestRedisRepository repository;

    @Transactional
    public TestRedis save(TestRedis testRedis) {
        // save
        TestRedis test = repository.save(testRedis);
        log.info("test = {}", test);
//        ValueOperations<String, String> value = redisTemplate.opsForValue();
        aa.set("test2", "@Resource");

        log.info("value = {}", "@Resource");
        return test;
    }

    public Optional<TestRedis> findById(String testId) {
        // find
        Optional<TestRedis> result = repository.findById(testId);
        log.info("result = {}", result);

        return result;
    }

    public Long count() {

        long count = repository.count();
        log.info("count = {}", count);
        return count;
    }

    public void delete() {
        repository.deleteAll();
    }

    public TestRedis update(TestRedis testRedis) {
        TestRedis save = repository.save(testRedis);
        return save;
    }
}
