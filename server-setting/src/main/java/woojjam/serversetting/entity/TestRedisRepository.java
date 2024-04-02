package woojjam.serversetting.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@RedisHash(value = "user", timeToLive = 10) // options: timeToLive = 10
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TestRedisRepository {
    @Id
    private String id;
    private String name;
    private int age;
    private LocalDateTime createdAt;
}
