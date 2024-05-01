package org.sopt.secondSeminar.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.secondSeminar.common.SuccessMessage;
import org.sopt.secondSeminar.dto.PostCreateRequest;
import org.sopt.secondSeminar.dto.PostDetailDto;
import org.sopt.secondSeminar.dto.SuccessStatusResponse;
import org.sopt.secondSeminar.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/blogs/{blogId}/posts")
    public ResponseEntity<SuccessStatusResponse> createPost(
            @RequestHeader Long memberId,
            @PathVariable Long blogId,
            @Valid @RequestBody PostCreateRequest postCreateRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).header(
                        "Location",
                        postService.create(memberId, blogId, postCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.POST_CREATE_SUCCESS));
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDetailDto> getPost(
            @PathVariable Long postId
    ) {
        return ResponseEntity.ok(postService.findPost(postId));
    }
}
