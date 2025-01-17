package pupket.togedogserver.global.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import static pupket.togedogserver.global.exception.ExceptionCode.NOT_HANDLED_EXCEPTION;

@JsonInclude
public record ExceptionResponse(String status, @JsonIgnore HttpStatus httpStatus, Integer code, String message) {

    public static ExceptionResponse fromException(ExceptionCode errorCode) {
        return new ExceptionResponse("REJECT",
                errorCode.getHttpStatus(),
                errorCode.getCode(),
                errorCode.getMessage());
    }

    public static ExceptionResponse fromError(Exception ex) {
        return new ExceptionResponse("ERROR",
                NOT_HANDLED_EXCEPTION.getHttpStatus(),
                NOT_HANDLED_EXCEPTION.getCode(),
                ex.getMessage());
    }
}