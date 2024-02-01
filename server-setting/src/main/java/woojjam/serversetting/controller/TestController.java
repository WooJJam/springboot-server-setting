package woojjam.serversetting.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import woojjam.serversetting.dtos.LoginRequestDto;
import woojjam.serversetting.dtos.UserResponseDto;
import woojjam.serversetting.exception.ErrorResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/test")
@Tag(name = "test 컨트롤러", description = "테스트 API입니다.")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "성공",  content = {@Content(schema = @Schema(implementation = UserResponseDto.class))}),
        @ApiResponse(responseCode = "500", description = "실패", content = {@Content(schema = @Schema(implementation = ErrorResponse.class))})
})
public class TestController {
    @Operation(summary = "hello 출력", description = "Hello 문자열을 출력합니다.")
    @GetMapping("/hello")
    public String pinrtHello() {
        return "hello";
    }

    @Operation(summary = "user 로그인", description = "유저가 로그인을 진행합니다.")
    @PostMapping("/login")
    public UserResponseDto login(LoginRequestDto loginRequestDto) {
        if (loginRequestDto.getEmail().equals("jaemin5548@naver.com")) {
            throw new RuntimeException();
        }
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(loginRequestDto.getEmail());
        userResponseDto.setPassword(loginRequestDto.getPassword());
        userResponseDto.setSex(loginRequestDto.getSex());
        return userResponseDto;
    }
}
