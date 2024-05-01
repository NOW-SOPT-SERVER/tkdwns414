package org.sopt.secondSeminar.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Blog blog;

    private Post(
            String title,
            String content,
            Blog blog
    ) {
        this.title = title;
        this.content = content;
        this.blog = blog;
    }

    public static Post create(
            Blog blog,
            String title,
            String content
    ) {
        return new Post(title, content, blog);
    }


}
