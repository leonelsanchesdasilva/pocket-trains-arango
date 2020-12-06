package leonel.pockettrainsarango.model;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Edge("cargoItems")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoItem {

    @Id
    private String id;
    private String description;
    private Integer slotSize;
    private Integer value;

    @From
    private City currentCity;

    @To
    private City destination;
}
