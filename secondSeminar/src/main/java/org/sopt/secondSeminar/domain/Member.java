package org.sopt.secondSeminar.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.secondSeminar.domain.enums.Part;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Part part;

    private int age;

    public static Member create(String name, Part part, int age) {
        Member member = new Member();
        member.name = name;
        member.part = part;
        member.age = age;
        return member;
    }
}
