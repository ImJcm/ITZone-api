package com.itzone.itzone.board;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
public class BoardRequestDto {
    @NotBlank(message = "게시글 제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "게시글 내용을 입력해주세요.")
    private String content;

    @NotBlank(message = "카테고리를 지정해주세요.")
    private int category;

    private List<MultipartFile> S3files;
}
