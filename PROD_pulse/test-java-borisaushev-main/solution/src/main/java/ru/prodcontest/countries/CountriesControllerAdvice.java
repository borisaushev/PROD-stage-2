package ru.prodcontest.countries;

import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.prodcontest.Json.JsonUtil;
import ru.prodcontest.countries.Exceptions.NoSuchCountryException;

import java.util.InputMismatchException;

@ControllerAdvice("ru.prodcontest.countries")
@ResponseBody
public class CountriesControllerAdvice {

    @ExceptionHandler(InputMismatchException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String badRequestException(InputMismatchException exc, HttpServletResponse response) throws JSONException {
        return JsonUtil.getJsonErrorResponse(400, exc.getMessage(), response);
    }

    @ExceptionHandler(NoSuchCountryException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String NoSuchCountryException(NoSuchCountryException exc, HttpServletResponse response) throws JSONException {
        return JsonUtil.getJsonErrorResponse(404, exc.getMessage(), response);
    }


}