package operasales.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PremiereMain {

    private String title;
    private String description;
    private int ageCategory;
    private int seatsLimit;
    private int tickets;
    private int id;

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
