package leonel.pockettrainsarango.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TrainFuelCar extends TrainPart {

    public TrainFuelCar(String id, TrainTechnology trainTechnology) {
        super(id, trainTechnology);
    }
}
