package woojjam.serversetting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import woojjam.serversetting.RedisRepository.TestRedisRepositoryRepo;
import woojjam.serversetting.entity.TestRedisRepository;

import java.util.Optional;

@SpringBootTest
public class RedisRepositoryTest {

    @Autowired
    private TestRedisRepositoryRepo repository;

    @Test
    @Transactional
    public void redisTest() throws Exception {

        TestRedisRepository redisRepository = new TestRedisRepository("11", "test",10);

        // 저장
        TestRedisRepository save = repository.save(redisRepository);

        Assertions.assertEquals(redisRepository, save);
        // "keyspace:id" 값 가저오기
        Optional<TestRedisRepository> findId = repository.findById(redisRepository.getId());
        Assertions.assertEquals(findId.get().getId(), redisRepository.getId());


        // Person Entity 의 @RedisHash 에 정의되어 있는 keyspace (people) 에 속한 키의 갯수를 구하기
        long count = repository.count();
        Assertions.assertEquals(count, 1);

        //삭제
//        repository.delete(redisRepository);
    }
}
