package com.darren.project.util;

public class Result {
    private boolean success;
    private String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Factory methods for convenience
    public static Result ok(String message) {
        return new Result(true, message);
    }

    public static Result error(String message) {
        return new Result(false, message);
    }
}