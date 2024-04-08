package com.itzone.itzone.common;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PageInfo {
    int page;
    int size;
    int totalElements;
    int totalPages;

    public static PageInfo of(int page, int size, int totalElements, int totalPages) {
        return PageInfo.builder()
                .page(page)
                .size(size)
                .totalElements(totalElements)
                .totalPages(totalPages)
                .build();
    }
}
