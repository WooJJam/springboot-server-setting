package woojjam.serversetting.repository;

import org.springframework.data.repository.CrudRepository;
import woojjam.serversetting.entity.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
