package operasales.events;

import lombok.*;


import javax.persistence.*;
import java.lang.String;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "premieres")
public class Premiere {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "ageCategory")
    private int ageCategory;

    @Column(name = "seatsLimit")
    private int seatsLimit;

    @Column(name = "tickets")
    private int tickets;

    @Column(name = "id", length = 12)
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
