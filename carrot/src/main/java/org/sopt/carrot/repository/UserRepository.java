package org.sopt.carrot.repository;

import org.sopt.carrot.domain.User;
import org.sopt.carrot.dto.type.ErrorCode;
import org.sopt.carrot.exception.CustomException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    default User findByIdOrThrow(final Long id) {
        return findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_USER)
        );
    }
}
