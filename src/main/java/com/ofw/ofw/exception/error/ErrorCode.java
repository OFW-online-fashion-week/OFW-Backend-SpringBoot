package com.ofw.ofw.exception.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    INVALID_INPUT_VALUE(400, "Invalid input value"),
    EXPIRED_ACCESS_TOKEN(401, "Expired access token"),
    USER_NOT_FOUND(404, "User not found"),
    BRAND_CACHE_NOT_FOUND(404, "Brand cache not found"),
    BRAND_NOT_FOUND(404, "Brand not found"),
    CREDENTIALS_NOT_FOUND(401, "Credentials not found"),
    RUNWAY_NOT_FOUND(404, "Runway not found"),
    COLLECTION_NOT_FOUND(404, "Runway not found"),
    DESIGNER_NOT_FOUND(404, "Designer not found"),
    PROFILE_NOT_FOUND(404, "Profile not found"),
    PASSWORD_NOT_FOUND(404, "Password not found"),
    MODEL_NOT_FOUND(404, "Model not found"),
    CLOTHES_NOT_FOUND(404, "Clothes not found");

    private final int status;
    private final String message;
}
