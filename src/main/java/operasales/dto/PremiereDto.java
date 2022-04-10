package operasales.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Data
public class PremiereDto {

    @JsonProperty
    private String title;

    @JsonProperty
    private String description;

    @JsonProperty
    private int ageCategory;

    @JsonProperty
    private int seatsLimit;

    @JsonProperty
    private int tickets;

    @JsonProperty
    private int id;
}
