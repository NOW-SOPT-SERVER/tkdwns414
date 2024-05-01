package org.sopt.secondSeminar.service;

import lombok.RequiredArgsConstructor;
import org.sopt.secondSeminar.domain.Post;
import org.sopt.secondSeminar.dto.PostCreateRequest;
import org.sopt.secondSeminar.dto.PostDetailDto;
import org.sopt.secondSeminar.exception.ErrorMessage;
import org.sopt.secondSeminar.exception.NotFoundException;
import org.sopt.secondSeminar.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BlogService blogService;

    @Transactional
    public String create(Long memberId, Long blogId, PostCreateRequest postCreateRequest) {
        blogService.checkBlogMember(blogId, memberId);
        return postRepository.save(
                Post.create(
                        blogService.findBlogById(blogId),
                        postCreateRequest.title(),
                        postCreateRequest.content()
                        )
        ).getId().toString();
    }

    @Transactional(readOnly = true)
    public PostDetailDto findPost(Long postId) {
        return PostDetailDto.of(findPostById(postId));
    }

    public Post findPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.POST_NOT_FOUND_BY_ID_EXCEPTION));
    }
}
