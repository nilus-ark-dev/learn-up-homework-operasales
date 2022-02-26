package operasales.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.lang.String;

@Getter
@Setter
@AllArgsConstructor
public class Premiere {

    private String title;
    private String description;
    private int ageCategory;
    private int seatsLimit;
    private int tickets;

    @Override
    public String toString() {
        return "Название: " +
                title + ";\n" +
                "Описание: " +
                description + ";\n" +
                "Возрастное ограничение: "
                + ageCategory + "+;\n" +
                "Количество посадочных мест: "
                + seatsLimit + ";\n" +
                "Количество доступных билетов: "
                + tickets + "\n";
    }
}
