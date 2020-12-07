package leonel.pockettrainsarango.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TrainEngine extends TrainPart {

    public TrainEngine(String id, TrainTechnology trainTechnology) {
        super(id, trainTechnology);
    }
}
