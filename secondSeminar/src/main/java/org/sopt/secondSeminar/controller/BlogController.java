package org.sopt.secondSeminar.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.secondSeminar.common.SuccessMessage;
import org.sopt.secondSeminar.dto.BlogCreateRequest;
import org.sopt.secondSeminar.dto.BlogTitleUpdateRequest;
import org.sopt.secondSeminar.dto.SuccessStatusResponse;
import org.sopt.secondSeminar.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/blogs")
    public ResponseEntity<SuccessStatusResponse> createBlog(
            @RequestHeader Long memberId,
            @RequestBody BlogCreateRequest blogCreateRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).header(
                        "Location",
                        blogService.create(memberId, blogCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.BLOG_CREATE_SUCCESS));
    }

    @PatchMapping("/blogs/{blogId}/title")
    public ResponseEntity<Void> updateBlogTitle(
            @PathVariable Long blogId,
            @Valid @RequestBody BlogTitleUpdateRequest blogTitleUdpateRequest
    ) {
        blogService.updateTitle(blogId, blogTitleUdpateRequest);
        return ResponseEntity.noContent().build();
    }
}

