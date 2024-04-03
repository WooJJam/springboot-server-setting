package woojjam.serversetting.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import woojjam.serversetting.entity.Member;
import woojjam.serversetting.repository.MemberRepository;

@RestController
@RequestMapping("/api/v1/cache")
@RequiredArgsConstructor
@Slf4j
public class RedisCacheController {

    private final MemberRepository memberRepository;

    @PostMapping("/save")
    public Member save(@RequestBody Member member) {
        Member saveMember = memberRepository.save(member);
        log.info("save to DB : {}",member);
        return saveMember;
    }

    @GetMapping("/test/{userId}")
    @Cacheable(key = "#userId", cacheNames = "member")
    public Member getMemberTest(@PathVariable("userId") Long userId) {
        Member member = memberRepository.findById(userId).orElseThrow(() -> new RuntimeException(userId + "멤버는 존재하지 않습니다."));
        log.info("Member fetching from DB : "+ userId);
        return member;
    }

    @GetMapping("/{userId}")
    public Member getMember(@PathVariable("userId") Long userId) {
        Member member = memberRepository.findById(userId).orElseThrow(() -> new RuntimeException(userId + "멤버는 존재하지 않습니다."));
        log.info("Member fetching from DB : "+ userId);
        return member;
    }
}
