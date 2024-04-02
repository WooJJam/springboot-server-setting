package woojjam.serversetting.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woojjam.serversetting.RedisRepository.TestRedisRepositoryRepo;
import woojjam.serversetting.entity.TestRedisRepository;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestRedisRepositoryService {

    private final TestRedisRepositoryRepo repository;
    private final RedisTemplate redisTemplate;

    @Transactional
    public void save(TestRedisRepository testRedis) {
        // save
        TestRedisRepository test = repository.save(testRedis);
        log.info("test = {}", test);
    }

    public Optional<TestRedisRepository> findById(String testId) {
        // find
        Optional<TestRedisRepository> result = repository.findById(testId);
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
        redisTemplate.delete("1");
    }

    public TestRedisRepository update(TestRedisRepository testRedis) {
        TestRedisRepository save = repository.save(testRedis);
        return save;
    }
}
