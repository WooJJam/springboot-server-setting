package woojjam.serversetting.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@Data
@Getter @Setter
public class TestRedisTemplate {

    @Id
    private String id;
    private String name;
    private int age;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;

    public TestRedisTemplate(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.createdAt = LocalDateTime.now();
    }
}
