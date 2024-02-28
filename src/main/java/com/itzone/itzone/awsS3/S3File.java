package com.itzone.itzone.awsS3;

import com.itzone.itzone.board.Board;
import com.itzone.itzone.comment.Comment;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "s3files")
public class S3File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String originalFileName;

    @Column
    private String uploadFileName;

    @Column
    private String uploadFilePath;

    @Column
    private String uploadFileUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Builder
    public S3File(String ofn, String ufn, String ufp, String ufu) {
        this.originalFileName = ofn;
        this.uploadFileName = ufn;
        this.uploadFilePath = ufp;
        this.uploadFileUrl = ufu;
    }

//    @Builder
//    public S3File(String ofn, String ufn, String ufp, String ufu, Board board, Comment comment) {
//        this.originalFileName = ofn;
//        this.uploadFileName = ufn;
//        this.uploadFilePath = ufp;
//        this.uploadFileUrl = ufu;
//        this.board = board;
//        this.comment = comment;
//    }

}
