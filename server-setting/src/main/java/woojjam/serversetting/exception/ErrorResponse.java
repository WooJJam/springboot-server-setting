package woojjam.serversetting.exception;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private String errorMessage;
    private String errorCode;
}
