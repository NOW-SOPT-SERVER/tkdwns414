package org.sopt.carrot.service;

import lombok.RequiredArgsConstructor;
import org.sopt.carrot.domain.User;
import org.sopt.carrot.dto.request.UserCreateDto;
import org.sopt.carrot.dto.response.UserDataDto;
import org.sopt.carrot.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(
            UserCreateDto userCreateDto
    ) {
        userRepository.save(User.create(userCreateDto.name()));
    }

    public UserDataDto getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다."));
        return UserDataDto.of(user);
    }
}
