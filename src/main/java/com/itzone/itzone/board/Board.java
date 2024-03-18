package com.itzone.itzone.board;

import com.itzone.itzone.awsS3.S3File;
import com.itzone.itzone.category.BoardBottomCategory;
import com.itzone.itzone.comment.Comment;
import com.itzone.itzone.common.TimeStamped;
import com.itzone.itzone.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "boards")
public class Board extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_bottom_id")
    private BoardBottomCategory bottomCategory;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<S3File> S3Files = new ArrayList<>();

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Board(String title, String content, User user, BoardBottomCategory bbc) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.bottomCategory = bbc;
    }

    public Board update(String title, String content) {
        this.title = title;
        this.content = content;

        return this;
    }

    public void setS3Files(S3File s3File) {
        this.S3Files.add(s3File);
    }
}
