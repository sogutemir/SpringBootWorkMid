package org.work.springbootwork.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.work.springbootwork.core.results.DataResult;
import org.work.springbootwork.core.results.Result;

public class ResponseUtil {

    public static <T> ResponseEntity<DataResult<T>> buildDataResultResponse(DataResult<T> result) {
        return result.isSuccess()
                ? ResponseEntity.ok(result)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    public static ResponseEntity<Result> buildResultResponse(Result result) {
        HttpStatus status = result.isSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(result);
    }
}
