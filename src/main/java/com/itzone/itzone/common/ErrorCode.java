package com.itzone.itzone.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    CREATE_ERROR("error.create"),
    UPDATE_ERROR("error.update");

    private final String message;
}