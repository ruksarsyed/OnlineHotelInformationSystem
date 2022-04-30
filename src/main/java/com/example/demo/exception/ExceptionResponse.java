package com.example.demo.exception;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class ExceptionResponse
{
    private String errorMessage;
    private String errorCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    
    public String getErrorMessage() {
        return this.errorMessage;
    }
    
    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public String getErrorCode() {
        return this.errorCode;
    }
    
    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }
    
    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }
    
    public void setTimestamp(final LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}