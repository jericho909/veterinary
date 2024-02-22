package dev.patika.veterinary.core.result;

import lombok.Getter;

@Getter
public class ResultWithData<T> extends Result{
    private T data;

    public ResultWithData(boolean status, String message, String httpCode, T data) {
        super(status, message, httpCode);
        this.data = data;
    }
}
