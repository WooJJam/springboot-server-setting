package woojjam.serversetting.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import woojjam.serversetting.dtos.LoginRequestDto;
import woojjam.serversetting.dtos.UserResponseDto;
import woojjam.serversetting.entity.TestRedis;
import woojjam.serversetting.exception.ErrorResponse;
import woojjam.serversetting.service.TestService;

import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/")
@Tag(name = "test 컨트롤러", description = "테스트 API입니다.")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "성공",  content = {@Content(schema = @Schema(implementation = UserResponseDto.class))}),
        @ApiResponse(responseCode = "500", description = "실패", content = {@Content(schema = @Schema(implementation = ErrorResponse.class))})
})
@RequiredArgsConstructor
public class TestController {

    private final TestService service;
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

    /**
     * @info    : Redis에 User 정보를 저장한다.
     * @name    : addUser
     * @version : 1.0.0
     */
    @PostMapping("/redis/save")
    public TestRedis saveTest(@RequestBody TestRedis testRedis) {
        log.info("Controller Request: {}", testRedis);
        service.save(testRedis);
        return testRedis;

    }// save

    @PostMapping("/redis/find-test")
    public Optional<TestRedis> findTest(@RequestBody Map<String, String> testId) {
        log.info("Controller Request: {}", testId);
        return service.findById(testId.get("id"));

    }// find

    @PostMapping("/redis/count")
    public Long count() {
        return service.count();
    }

    @PostMapping("/redis/delete")
    public String delete() {
        service.delete();
        return "Success";
    }

    @PostMapping("/redis/update")
    public TestRedis update(@RequestBody TestRedis testRedis) {
        return service.update(testRedis);
    }
}
