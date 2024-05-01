package org.sopt.secondSeminar.dto;

import org.sopt.secondSeminar.domain.Post;

public record PostDetailDto(
        Long id,
        String title,
        String content
) {
    public static PostDetailDto of(Post post) {
        return new PostDetailDto(
                post.getId(),
                post.getTitle(),
                post.getContent()
        );
    }
}
