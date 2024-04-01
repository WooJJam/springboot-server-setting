//package woojjam.serversetting;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//import woojjam.serversetting.RedisRepository.TestRedisRepository;
//import woojjam.serversetting.entity.RedisTest;
//
//@SpringBootTest
//public class RedisRepositoryTest {
//
//    @Autowired
//    private TestRedisRepository repository;
//
//    @Test
//    @Transactional
//    public void redisTest() throws Exception {
//
//        RedisTest redisTest = new RedisTest("test", 10);
//
//        // 저장
//        repository.save(redisTest);
//
//        // "keyspace:id" 값 가저오기
//        repository.findById(redisTest.getId());
//
//        // Person Entity 의 @RedisHash 에 정의되어 있는 keyspace (people) 에 속한 키의 갯수를 구하기
//        repository.count();
//
//        //삭제
//        repository.delete(redisTest);
//    }
//}
