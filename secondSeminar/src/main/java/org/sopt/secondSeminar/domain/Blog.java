package org.sopt.secondSeminar.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Blog extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(length = 200)
    private String title;

    private String description;

    private Blog(
            Member member,
            String title,
            String description
    ) {
        this.member = member;
        this.title = title;
        this.description = description;
    }

    public static Blog create(
            Member member,
            String title,
            String description) {
        return new Blog(member, title, description);
    }

    public void updateTitle(String title) {
        this.title = title;
    }
}
