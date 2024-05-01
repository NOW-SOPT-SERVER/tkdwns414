package org.sopt.carrot.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.carrot.dto.common.ApiResponse;
import org.sopt.carrot.dto.request.UserCreateDto;
import org.sopt.carrot.dto.response.UserDataDto;
import org.sopt.carrot.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ApiResponse<Void> createUser(
            @RequestBody final UserCreateDto userCreateDto
    ) {
        userService.createUser(userCreateDto);
        return ApiResponse.created(null);
    }

    @GetMapping("/{userId}")
    public ApiResponse<UserDataDto> getUser(
            @PathVariable final Long userId
    ) {
        return ApiResponse.ok(userService.getUser(userId));
    }
}
