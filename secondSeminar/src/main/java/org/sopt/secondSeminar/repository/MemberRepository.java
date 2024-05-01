package org.sopt.secondSeminar.repository;

import jakarta.persistence.EntityNotFoundException;
import org.sopt.secondSeminar.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
