package org.sopt.secondSeminar.service;

import lombok.RequiredArgsConstructor;
import org.sopt.secondSeminar.domain.Blog;
import org.sopt.secondSeminar.domain.Member;
import org.sopt.secondSeminar.dto.BlogCreateRequest;
import org.sopt.secondSeminar.dto.BlogTitleUpdateRequest;
import org.sopt.secondSeminar.exception.ErrorMessage;
import org.sopt.secondSeminar.exception.ForbiddenException;
import org.sopt.secondSeminar.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberService memberService;

    @Transactional
    public String create(Long memberId, BlogCreateRequest createRequest) {
        Member member = memberService.findMemberById(memberId);
        Blog blog = blogRepository.save(Blog.create(member, createRequest.title(), createRequest.description()));
        return blog.getId().toString();
    }

    @Transactional
    public void updateTitle(
            Long blogId,
            BlogTitleUpdateRequest blogTitleUpdateRequest
    ) {
        Blog blog = findBlogById(blogId);
        blog.updateTitle(blogTitleUpdateRequest.title());
    }

    public void checkBlogMember(Long blogId, Long memberId) {
        Blog blog = findBlogById(blogId);
        if (!blog.getMember().getId().equals(memberId)) {
            throw new IllegalArgumentException("해당 블로그의 작성자가 아닙니다.");
        }
    }

    public Blog findBlogById(Long blogId) {
        return blogRepository.findById(blogId)
                .orElseThrow(() -> new ForbiddenException(ErrorMessage.BLOG_PERMISSION_DENIED));
    }

}
