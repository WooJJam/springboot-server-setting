package woojjam.serversetting.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@RedisHash("user") // options: timeToLive = 10
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TestRedis {
    @Id
    private String id;
    private String name;
    private int age;
    private LocalDateTime createdAt;

    public TestRedis(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.createdAt = LocalDateTime.now();
    }
}
