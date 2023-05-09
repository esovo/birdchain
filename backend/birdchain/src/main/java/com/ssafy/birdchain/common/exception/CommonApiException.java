package com.ssafy.birdchain.common.exception;

import com.ssafy.birdchain.common.exception.errorcode.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommonApiException extends RuntimeException {
    private final ErrorCode errorCode;

}
