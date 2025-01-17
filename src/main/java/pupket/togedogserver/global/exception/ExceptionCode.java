package pupket.togedogserver.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ExceptionCode {
    // 500
    NOT_HANDLED_EXCEPTION(INTERNAL_SERVER_ERROR, "Unhandled exception occurred.", 500),
    REDIS_CONNECTION_FAILURE(INTERNAL_SERVER_ERROR, "Failed to connect to Redis.", 500),
    EMAIL_SEND_FAILURE(INTERNAL_SERVER_ERROR, "Failed to send email.", 500),
    UNEXPECTED_ERROR(INTERNAL_SERVER_ERROR, "An unexpected error occurred.", 500),

    // 400
    PASSWORD_MISMATCH(BAD_REQUEST, "Passwords do not match.", 400),
    INVALID_CURRENT_PASSWORD(BAD_REQUEST, "The current password is incorrect.", 400),
    INVALID_AUTH_CODE(BAD_REQUEST, "Invalid email authentication code.", 400),
    NOT_FOUND_REFRESH_TOKEN_IN_COOKIE(BAD_REQUEST, "Refresh token not found in cookie.", 400),
    INVALID_PARAMETER(BAD_REQUEST, "Invalid request parameter.", 400),
    INVALID_FILE_EXTENTION(BAD_REQUEST, "Invalid File Extention", 400),
    INVALID_ENUM_PARAMETER(BAD_REQUEST, "Invalid Enum Parameter", 400),


    // 401
    UNAUTHORIZED_LOGIN(UNAUTHORIZED, "Login failed: authentication failed.", 401),
    TOKEN_EXPIRED(UNAUTHORIZED, "Token has expired.", 401),
    INVALID_TOKEN(UNAUTHORIZED, "Invalid token provided.", 401),
    UNSUPPORTED_TOKEN(UNAUTHORIZED, "Token format is unsupported.", 401),
    NOT_FOUND_TOKEN(UNAUTHORIZED, "Token not found.", 401),
    NOT_FOUND_REFRESH_TOKEN(UNAUTHORIZED, "Refresh token not found for the user.", 401),
    INVALID_AUTHENTICATION(UNAUTHORIZED, "Invalid authentication.", 401),
    MALFORMED_TOKEN(UNAUTHORIZED, "Malformed token.", 401),
    EXPIRED_TOKEN(UNAUTHORIZED, "Expired token.", 401),
    // 403
    DUPLICATE_RESOURCE(CONFLICT, "Resource already exists.", 403),
    NOT_FOUND_MEMBER(CONFLICT, "Member not found.", 403),
    NOT_FOUND_OWNER(CONFLICT, "Owner not found.", 403),
    NOT_FOUND_MATE(CONFLICT, "Mate not found.", 403),
    NOT_FOUND_BOARD(CONFLICT, "Board not found.", 403),
    NOT_FOUND_MATCH(CONFLICT, "Match not found.", 403),
    NOT_FOUND_CHATROOM(CONFLICT, "Room not found.", 403),
    MEMBER_ALREADY_EXISTS(CONFLICT, "Member already exists.", 403),
    MATE_ALREADY_EXIST(CONFLICT, "MATE already exists", 403),
    NICKNAME_ALREADY_EXISTS(CONFLICT, "Nickname already exists.", 403),
    NOT_MATCHED_WRITER(CONFLICT, "Writer does not match.", 403),
    INVALID_BOARD(CONFLICT, "Invalid board.", 403),
    MEMBER_ALREADY_WITHDRAW(CONFLICT, "Member has already withdrawn.", 403),
    NOT_FOUND_BOARDCOMMENT(CONFLICT, "Board comment not found.", 403),
    NOT_FOUND_DOG(CONFLICT, "Dog not found", 403),
    NOT_FOUND_MATE_TAG(CONFLICT, "Dog not Mate Tag", 403),
    DOG_ALREADY_EXISTS(CONFLICT, "Dog already exists.", 403),
    AVAILABLE_FOR_REGISTRATION_EXCEEDED(CONFLICT, "Available for registration exceeded(Max=5)", 403),
    NOT_FOUND_WALKING_PLACE_TAG(CONFLICT, "WalkingPlaceTag not found", 403),
    FILE_IS_EMPTY(CONFLICT, "File is Empty", 403),
    IO_EXCEPTION_ON_IMAGE_UPLOAD(CONFLICT, "IO Exception happened on Image Upload", 403),
    NO_FILE_EXTENTION(CONFLICT, "No file Extention", 403),
    PUT_OBJECT_EXCEPTION(CONFLICT, "Put Object Exception", 403),
    IO_EXCEPTION_ON_IMAGE_DELETE(CONFLICT, "IO Exception on Image Delete", 403),
    YOUR_OWN_NICKNAME(CONFLICT,"Parameter is your own nickname" ,403 ),
    ALREADY_ACCEPTED(CONFLICT,"Matching Already Accepted, Somebody Accepted" , 403),
    ALREADY_REJECTED(CONFLICT,"MATCHING ALREADY ACCEPTED" , 403),
    ALREADY_MATCHED(CONFLICT, "Already Matched",403),
    NOT_YOUR_DOG(CONFLICT, "Not your Dog, Check your Dog Id" , 403)
    , ACCEPT_SHOULD_TRY_RECIEVER(CONFLICT,"Board Writer Can't Accept" , 403)
    , NOT_FOUND_BOARDDOG(CONFLICT,"Can't find BoardDog",403 )
    , ALREADY_COMPLETED(CONFLICT,"Matching Already Completed" , 403 )
    , MATE_NOT_REGIST(CONFLICT,"Mate Not Register" ,403 )
    , DUPLICATE_LOGIN(CONFLICT,"Duplicate Login" , 403 );


    private final HttpStatus httpStatus;
    private final String message;
    private final Integer code;
}
