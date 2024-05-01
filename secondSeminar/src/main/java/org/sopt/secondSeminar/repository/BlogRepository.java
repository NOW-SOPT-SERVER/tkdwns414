package org.sopt.secondSeminar.repository;

import org.sopt.secondSeminar.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
