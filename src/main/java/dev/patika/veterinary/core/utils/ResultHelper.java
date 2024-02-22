package dev.patika.veterinary.core.utils;

import dev.patika.veterinary.core.result.Result;
import dev.patika.veterinary.core.result.ResultWithData;

public class ResultHelper {
    public static <T> ResultWithData<T> created(T data){
        return new ResultWithData<>(true, Msg.CREATED, "201", data);
    }

    public static <T> ResultWithData<T> validateError(T data){
        return new ResultWithData<>(false, Msg.VALIDATE_ERROR, "400", data);
    }

    public static <T> ResultWithData<T> ok(T data){
        return new ResultWithData<>(true, Msg.OK, "200", data);
    }

    public static Result successfulOperation(){
        return new Result(true, Msg.OK, "200");
    }

    public static Result notFoundError(String message){
        return new Result(false, message, "404");
    }

    public static Result internalServerError(String message){return new Result(false, message, "500");}

}
