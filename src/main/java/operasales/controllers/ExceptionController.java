package operasales.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import operasales.dto.ErrorDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ErrorDto handle(Exception err) {
        Random rand = new Random();
        rand.nextInt(100);
        return new ErrorDto(rand.nextInt(100), err.getMessage());
    }
}
