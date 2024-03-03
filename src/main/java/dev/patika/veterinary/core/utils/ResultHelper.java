package dev.patika.veterinary.core.utils;

import dev.patika.veterinary.core.result.Result;
import dev.patika.veterinary.core.result.ResultWithData;
import dev.patika.veterinary.dto.responses.CursorResponse;
import org.springframework.data.domain.Page;

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

    public static <T> ResultWithData<CursorResponse<T>> cursor(Page<T> pageCursor){
        CursorResponse<T> cursorResponse = new CursorResponse<>();
        cursorResponse.setItems(pageCursor.getContent());
        cursorResponse.setPageNumber(pageCursor.getNumber());
        cursorResponse.setPageSize(pageCursor.getSize());
        cursorResponse.setTotalElement(pageCursor.getTotalElements());
        return ResultHelper.ok(cursorResponse);
    }

    public static <T> ResultWithData<T> doctorNotAvailable(T data){
        return new ResultWithData<>(false,Msg.DOCTOR_NOT_AVAILABLE, "422", data);
    }
    public static <T> ResultWithData<T> animalNotFound(T data){
        return new ResultWithData<>(false,Msg.ANIMAL_NOT_FOUND, "404", data);
    }

    public static <T> ResultWithData<T> emailInSystem(T data){
        return new ResultWithData<>(false,Msg.EMAIL_EXISTS, "400", data);
    }

    public static <T> ResultWithData<T> phoneInSystem(T data){
        return new ResultWithData<>(false,Msg.PHONE_EXISTS, "400", data);
    }

    public static <T> ResultWithData<T> appointmentAlreadyMade(T data){
        return new ResultWithData<>(false,Msg.APPOINTMENT_EXISTS, "400", data);
    }

    public static <T> ResultWithData<T> vaccineInSystem(T data){
        return new ResultWithData<>(false, Msg.VACCINE_EXISTS, "400", data);
    }

    public static <T> ResultWithData<T> vaccineStillInEffect(T data){
        return new ResultWithData<>(false, Msg.VACCINE_PROTECTION_IN_EFFECT, "422", data);
    }

}
