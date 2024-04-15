package org.sopt.secondSeminar.repository;

import jakarta.persistence.EntityNotFoundException;
import org.sopt.secondSeminar.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    default Member findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다."));
    }
}
