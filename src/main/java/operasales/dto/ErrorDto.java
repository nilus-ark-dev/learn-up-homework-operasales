package operasales.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ErrorDto {

    public ErrorDto(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @JsonProperty
    private int code;

    @JsonProperty
    private String message;
}
