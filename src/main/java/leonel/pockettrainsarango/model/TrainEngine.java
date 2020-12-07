package leonel.pockettrainsarango.model;

import com.arangodb.springframework.annotation.Ref;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainEngine {

    @Id
    private String id;

    @Ref
    private TrainTechnology trainTechnology;
}
