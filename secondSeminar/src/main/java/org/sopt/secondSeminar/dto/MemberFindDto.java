package org.sopt.secondSeminar.dto;

import org.sopt.secondSeminar.domain.Member;
import org.sopt.secondSeminar.domain.enums.Part;

public record MemberFindDto(
        String name,
        Part part,
        int age
) {
    public static MemberFindDto of(
            Member member
    ) {
        return new MemberFindDto(
                member.getName(),
                member.getPart(),
                member.getAge()
        );
    }
}
