package org.sopt.secondSeminar.dto;

import org.sopt.secondSeminar.domain.enums.Part;

public record MemberCreateDto(
        String name,
        Part part,
        int age
) {
}
