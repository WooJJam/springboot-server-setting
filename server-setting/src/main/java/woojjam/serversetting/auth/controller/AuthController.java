package woojjam.serversetting.auth.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import woojjam.serversetting.auth.dto.KakaoUserInfoDto;
import woojjam.serversetting.auth.service.AuthService;

import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @GetMapping("/kakao/login")
    public String renderLoginView() {
        return "login";
    }

    @ResponseBody
    @PostMapping("/kakao/login")
    public KakaoUserInfoDto kakaoLogin(@RequestBody Map<String, String> request) throws ParseException {
        String code = request.get("code");
        return authService.kakaoLogin(code);
    }

}
