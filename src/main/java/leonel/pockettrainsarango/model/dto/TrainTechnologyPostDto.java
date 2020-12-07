package leonel.pockettrainsarango.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrainTechnologyPostDto {

    private String name;
    private Integer speed;
    private Integer baseCapacity;
    private Integer baseFuel;
    private Integer peerEngines;
    private Integer fuelCars;
}
