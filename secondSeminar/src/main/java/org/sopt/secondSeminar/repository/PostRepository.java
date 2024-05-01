package org.sopt.secondSeminar.repository;

import org.sopt.secondSeminar.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
