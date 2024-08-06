package com.project.mission1.exception;

import lombok.Getter;

import java.util.Map;

public class UsernameException extends RuntimeException{

    @Getter
    Map<String, String> errorMap;

    public UsernameException(Map<String, String> errorMap) {
        super("아이디 중복 오류");
        this.errorMap = errorMap;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

}
