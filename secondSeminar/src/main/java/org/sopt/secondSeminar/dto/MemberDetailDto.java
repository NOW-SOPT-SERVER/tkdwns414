package org.sopt.secondSeminar.dto;

import org.sopt.secondSeminar.domain.Member;
import org.sopt.secondSeminar.domain.enums.Part;

public record MemberDetailDto(
        Long id,
        String name,
        Part part,
        int age
) {

    public static MemberDetailDto of(
            Member member
    ) {
        return new MemberDetailDto(
                member.getId(),
                member.getName(),
                member.getPart(),
                member.getAge()
        );
    }
}
