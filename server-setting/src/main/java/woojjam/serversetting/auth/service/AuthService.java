package woojjam.serversetting.auth.service;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import woojjam.serversetting.auth.dto.KakaoTokenDto;
import woojjam.serversetting.auth.dto.KakaoUserInfoDto;

@Slf4j
@Service
public class AuthService {

    @Value("${KAKAO.REDIRECT.URI}")
    private String redirectUri;
    @Value("${KAKAO.REST.API.KEY}")
    private String restAPiKey;

    public KakaoUserInfoDto kakaoLogin(String code) throws ParseException {
        return getAccessToken(code);
    }

    private KakaoUserInfoDto getAccessToken(String code) {
        log.info("code = {}", code);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");

            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("grant_type", "authorization_code");
            body.add("client_id", restAPiKey);
            body.add("redirect_uri", redirectUri);
            body.add("code", code);

            HttpEntity<MultiValueMap<String, String>> kakaoRequest = new HttpEntity<>(body, headers);
            log.info("KAKAO REQUEST = {}", kakaoRequest);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> kakaoToken = restTemplate.exchange(
                    "https://kauth.kakao.com/oauth/token",
                    HttpMethod.POST,
                    kakaoRequest,
                    String.class
            );
            System.out.println("kakaoToken = " + kakaoToken.getBody());
            log.info("KAKAO TOKEN ={}", kakaoToken);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(kakaoToken.getBody());

            KakaoTokenDto kakaoTokenDto = new KakaoTokenDto(
                    (String) jsonObject.get("access_token"),
                    (String) jsonObject.get("refresh_token"));

            return getKakaoUserInfo(kakaoTokenDto);

        } catch (ParseException e) {
            log.error(e.getMessage());
        }

        return null;
    }


    private KakaoUserInfoDto getKakaoUserInfo(KakaoTokenDto kakaoTokenDto) throws ParseException {
        log.info("KAKAO TOKEN DTO = {}",kakaoTokenDto);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(kakaoTokenDto.getAccessToken());
        headers.setContentType(MediaType.valueOf("application/x-www-form-urlencoded;charset=utf-8"));
        HttpEntity body = new HttpEntity(null, headers);

        log.info("Get Kakao User Info API Http Body = {}", body);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> kakaoUser = restTemplate.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                body,
                String.class
        );
        log.info("KAKAO USER = {}", kakaoUser);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(kakaoUser.getBody());
        JSONObject kakaoAccount = (JSONObject) jsonObject.get("kakao_account");
        JSONObject profile = (JSONObject) kakaoAccount.get("profile");
        String nickname = String.valueOf(profile.get("nickname"));
        String email = String.valueOf(kakaoAccount.get("email"));

        log.info("Nickname = {}, email = {}", nickname, email);

        return new KakaoUserInfoDto(nickname, email);

    }


}
