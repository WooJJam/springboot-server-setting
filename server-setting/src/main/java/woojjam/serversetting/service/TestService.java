package woojjam.serversetting.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woojjam.serversetting.RedisRepository.TestRedisRepository;
import woojjam.serversetting.entity.TestRedis;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRedisRepository repository;

    @Transactional
    public TestRedis save(TestRedis testRedis) {
        // save
        TestRedis test = repository.save(testRedis);
        log.info("test = {}", test);
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
}
