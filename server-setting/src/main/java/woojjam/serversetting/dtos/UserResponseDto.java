package woojjam.serversetting.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "회원가입 응답 dto")
@Getter @Setter
public class UserResponseDto {

    @Email
    @Schema(description = "유제 이메일", nullable = false, example = "abc@example.com")
    private String email;

    @Schema(description = "유저 패스워드", nullable = false)
    private String password;

    @Schema(description = "성별", defaultValue = "M", allowableValues = {"M", "F"})
    private String sex;
}
