package woojjam.serversetting.RedisRepository;

import org.springframework.data.repository.CrudRepository;
import woojjam.serversetting.entity.TestRedis;

public interface TestRedisRepository extends CrudRepository<TestRedis, String> {
}
