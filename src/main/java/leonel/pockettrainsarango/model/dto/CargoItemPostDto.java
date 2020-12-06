package leonel.pockettrainsarango.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CargoItemPostDto {

    private String currentCity;
    private String destination;
    private String description;
    private Integer slotSize;
    private Integer value;
}
