package woojjam.serversetting.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class LoginRequestDto {

    @Email
    private String email;
    private String password;
    private String sex;
}
